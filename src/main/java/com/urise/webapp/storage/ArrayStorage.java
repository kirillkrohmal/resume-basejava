package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    private final int STORAGE_MAX_SIZE = 10000;
    private Resume[] storage = new Resume[STORAGE_MAX_SIZE];
    private int size = 0;

    public void save(Resume r) {
        if(size == STORAGE_MAX_SIZE - 1){
            System.out.println("storage is full!");
            return;
        }
        if(getIndex(r.getUuid()) > 0){
            System.out.println("Sorry but uuid " + r.getUuid() + " already exist!");
            return;
        }
        storage[size] = r;
        size++;
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

    public int size() {
        //если ввели значение "size" получим размер резюме
        return size;
    }

    public int getIndex(String uuid){
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
