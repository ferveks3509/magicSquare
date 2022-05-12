package com.testproject.service;

import com.testproject.model.ContainsStrModel;
import com.testproject.repository.ContainsStrRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.TreeSet;

@Service
public class ContainsStrService {

    private final ContainsStrRepository containsStrRepository;

    public ContainsStrService(ContainsStrRepository containsStrRepository) {
        this.containsStrRepository = containsStrRepository;
    }

    /**
     * Поиск строк в подстроках
     *
     * @param inputFirst  Строки
     * @param inputSecond Подсткроки
     * @return коллекцию в отсортированном виде без дубликатов
     */
    public TreeSet<String> sortedString(String inputFirst, String inputSecond) {
        TreeSet<String> rsl = new TreeSet<>();
        String[] first = inputFirst.split(" ");
        String[] second = inputSecond.split(" ");
        for (String value : first) {
            for (String s : second) {
                if (s.contains(value)) {
                    rsl.add(value);
                }
            }
        }
        return rsl;
    }

    /**
     * Поиск строк в подстроках и сохранение результата в БД
     *
     * @param inputFirst
     * @param inputSecond
     * @return коллекцию в отсортированном виде без дубликатов
     */
    public TreeSet<String> sortedSave(String inputFirst, String inputSecond) {
        ContainsStrModel containsStrModel = new ContainsStrModel();
        containsStrModel.setInputStr(inputFirst);
        containsStrModel.setCompareStr(inputSecond);
        containsStrModel.setCreated(LocalDate.now());
        containsStrModel.setResult(sortedString(inputFirst, inputSecond).toString());
        containsStrRepository.save(containsStrModel);
        return sortedString(inputFirst, inputSecond);
    }

    /**
     * Сохраняет строки и подстроки в файл
     *
     * @param inputFirst
     * @param inputSecond
     * @param nameFile
     */
    public void saveFile(String inputFirst, String inputSecond, String nameFile) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(nameFile)
                )
        )) {
            out.println(inputFirst);
            out.println(inputSecond);
            out.println("Тип задачи: ContainsStr");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Поиск по дате
     *
     * @param localDate 2022-05-12(формат даты)
     * @return коллекция со всеми идентичными датами
     */
    public List<ContainsStrModel> findByDate(String localDate) {
        return containsStrRepository.findByCreated(localDate);
    }

    /**
     * Чтение данных из файла и конвертация в обьект ContainsStrModel
     *
     * @param fileName
     * @return ContainsStrModel c состоянием
     */
    public ContainsStrModel loadFile(String fileName) {
        ContainsStrModel containsStrModel = new ContainsStrModel();
        try (BufferedReader in = new BufferedReader(
                new FileReader(fileName)
        )) {
            containsStrModel.setInputStr(in.readLine());
            containsStrModel.setCompareStr(in.readLine());
            containsStrModel.setCreated(LocalDate.now());
        } catch (IOException e) {
            e.printStackTrace();
        }
        containsStrModel.setResult(sortedString(containsStrModel.getInputStr(),
                containsStrModel.getCompareStr()).toString());
        return containsStrModel;
    }
}