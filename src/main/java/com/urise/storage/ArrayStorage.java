package com.urise.storage;

import com.urise.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int STORAGE_MAX_SIZE = 10000;
    private Resume[] storage = new Resume[STORAGE_MAX_SIZE];
    private int size = 0;

    public void clear() {//если ввели значение "clear" очищаем все резюме в налл
        storage = null;
    }

    public int update(Resume r) {
        //если ввели значение "update" заменяем одно резюме другим по id
        int index = 0;
        while (index < size) {
            if (storage[index] != null)
                return index;
            index++;
        }

        return index;
    }

    public void save(Resume r) {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if(size == STORAGE_MAX_SIZE - 1){
            System.out.println("storage is full!");
            return;
        }
        if(getIndex(r.toString()) > 0){
            System.out.println("Sorry but uuid " + r.getUuid() + " already exist!");
            return;
        }
        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        //если ввели значение "get" получаем резюме
        int index = getIndex(uuid);
        if(index < 0){
            System.out.println("Sorry but resume with uuid" + uuid + " is apsend!");
            return null;
        }

        return storage[index];
    }

    public void delete(String uuid) {
        //если ввели значение "delete" одно резюме в налл
        int index = 0;
        if (index == -1) {
            System.out.println("The value " + uuid + " was not found and cannot be deleted.");
        } else {
            for (int i = 0; i < storage.length - 1; i++) {
                storage[i] = storage[i + 1];
            }


       /* int index = 0;
        if (index == -1) {
            System.out.println("Resume with" + uuid + " was not found and cannot be deleted.");
        } else {
            int size = storage.length;
            for (int i = index; i < size; i++) {
                if (i < (size - 1)) {
                    storage[i] = storage[i + 1];
                } else
                    return; //set to some base case or zero
            }*/
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        //если ввели значение "getAll" получаем все резюме
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }

        return resumes;
    }

    public int size() {
        //если ввели значение "size" получим размер резюме
        return size;
    }

    private int getIndex(String uuid){
        for (int i = 0; i < size; i++) {
            if(storage[i].getUuid().equals(uuid)){
                return i;
            }
        }
        return -1;
    }
/*
    int index = 0;
            while (index < size) {
        if (storage[index] == x)
            return index;
        index++;
    }
            return -1;*/
}
