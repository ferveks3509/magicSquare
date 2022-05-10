package com.testproject.service;

import com.testproject.model.MagicSquareModel;
import com.testproject.repository.MagicSquareRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MagicSquareService {

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

    public MagicSquareModel save(String input) {
        MagicSquareModel magicSquareModel = new MagicSquareModel();
        sorted(input, magicSquareModel);
        magicSquareRepository.save(magicSquareModel);
        return magicSquareModel;
    }

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

//    public int[] toArr(int[][] grid) {
//        int z = 0;
//        int[] w = new int[9];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                w[z++] = grid[i][j];
//            }
//        }
//        return w;
//    }
//    public int[] sort(int[] arr) {
//        int temp = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != CONST[i]) {
//                for (int j = 0; j < arr.length; j++) {
//                    if (arr[j] == CONST[i]) {
//                        temp = arr[i];
//                        arr[i] = arr[j];
//                        arr[j] = temp;
//                        count++;
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//    public boolean checkMagic(int[][] grid) {
//        if     (grid[0][0] + grid[0][1] + grid[0][2] == 15 &&
//                grid[1][0] + grid[1][1] + grid[1][2] == 15 &&
//                grid[2][0] + grid[2][1] + grid[2][2] == 15 &&
//
//                grid[0][0] + grid[1][0] + grid[2][0] == 15 &&
//                grid[1][0] + grid[1][1] + grid[1][2] == 15 &&
//                grid[2][0] + grid[2][1] + grid[2][2] == 15 &&
//
//                grid[0][0] + grid[1][1] + grid[2][2] == 15 &&
//                grid[0][2] + grid[1][1] + grid[2][0] == 15) {
//            return true;
//        }
//        return false;
//    }
//
//    public void print() {
//        for (int[] row : square) {
//            for (int cell : row) {
//                System.out.print(cell + " ");
//            }
//            System.out.println();
//        }
//    }
}
