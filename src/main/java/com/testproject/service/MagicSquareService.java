package com.testproject.service;

import com.testproject.model.MagicSquareModel;
import com.testproject.repository.MagicSquareRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MagicSquareService {

    /**
     * варианты магического квадрата
     */
    private final int[] CONST = new int[] {4, 3, 8, 2, 7, 6, 9, 5, 1};

    private final MagicSquareRepository magicSquareRepository;

    public MagicSquareService(MagicSquareRepository magicSquareRepository) {
        this.magicSquareRepository = magicSquareRepository;
    }

    public List<MagicSquareModel> findAll() {
        List<MagicSquareModel> data = new ArrayList<>();
        magicSquareRepository.findAll().forEach(data::add);
        return data;
    }

    public List<MagicSquareModel> findByDate(String localDate) {
        //LocalDate.parse(localDate)
        return magicSquareRepository.findByCreated(localDate);
    }

    public MagicSquareModel save(String input) {
        MagicSquareModel magicSquareModel = new MagicSquareModel();
        sorted(input, magicSquareModel);
        magicSquareModel.setCreated(LocalDate.now());
        magicSquareRepository.save(magicSquareModel);
        return magicSquareModel;
    }
    
    public MagicSquareModel result(String input) {
        MagicSquareModel magicSquareModel = new MagicSquareModel();
        sorted(input, magicSquareModel);
        return magicSquareModel;
    }

    public void saveFile(String input, String nameFile){
       try(PrintWriter out = new PrintWriter(
               new BufferedOutputStream(
                       new FileOutputStream(nameFile)
               )
       )){
           out.println(input);
           out.println("Тип задачи: MagicSquare");
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    /**
     *
     * @param str набор данных пользователя
     * @param magicSquareModel
     * @return магический квадрат с кол-вом перестановок чисел
     */
    private MagicSquareModel sorted(String str, MagicSquareModel magicSquareModel) {
        int temp = 0;
        int count = 0;
        StringBuilder st = new StringBuilder();
        char[] arr = str.toCharArray();
        int[] mgSquare = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mgSquare[i] = (int) arr[i] - '0';
        }
        if (!checkMagicSquare(mgSquare)) {
            for (int i = 0; i < mgSquare.length; i++) {
                if (mgSquare[i] != CONST[i]) {
                    for (int j = 0; j < mgSquare.length; j++) {
                        if (mgSquare[j] == CONST[i]) {
                            temp = mgSquare[i];
                            mgSquare[i] = mgSquare[j];
                            mgSquare[j] = temp;
                            count++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < mgSquare.length; i++) {
            st.append(mgSquare[i]);
        }
        magicSquareModel.setResult(count);
        magicSquareModel.setInput(st.toString());
        return magicSquareModel;
    }

    /**
     *
     * @param input массив чисел
     * @return является квадрат магическим
     */
    private boolean checkMagicSquare(int[] input) {
        if (input[0] + input[1] + input[2] == 15 &&
            input[3] + input[4] + input[5] == 15 &&
            input[6] + input[7] + input[8] == 15 &&

            input[0] + input[3] + input[6] == 15 &&
            input[1] + input[4] + input[7] == 15 &&
            input[2] + input[5] + input[8] == 15 &&

            input[0] + input[4] + input[8] == 15 &&
            input[2] + input[4] + input[6] == 15) {
            return true;
        }
        return false;
    }
}
