package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    private final int STORAGE_MAX_SIZE = 10000;
    private int size = 0;
    private Resume[] storage = new Resume[STORAGE_MAX_SIZE];

    @Override
    public void save(Resume r) {
        if (size == STORAGE_MAX_SIZE - 1) {
            System.out.println("storage is full!");
            return;
        }
        if (getIndex(r.getUuid()) > 0) {
            System.out.println("Sorry but uuid " + r.getUuid() + " already exist!");
            return;
        }
        storage[size] = r;
        size++;
    }

    @Override
    public void delete(String uuid) {
        //если ввели значение "delete" одно резюме в налл
        int index = 0;
        if (index == -1) {
            System.out.println("The value " + uuid + " was not found and cannot be deleted.");
        } else {
            for (int i = 0; i < storage.length - 1; i++) {
                storage[i] = storage[i + 1];
            }
        }
    }

    @Override
    public void clear() {
        //если ввели значение "clear" очищаем все резюме в налл
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    @Override
    public void update(Resume r) {
        //если ввели значение "update" заменяем одно резюме другим по id
        int index = getIndex(r.getUuid());

        if (index == -1) {
            System.out.println("Sorry but uuid " + r.getUuid() + " not exist!");
            return;
        }
        storage[index] = r;
    }


    @Override
    public Resume get(String uuid) {
        //если ввели значение "get" получаем резюме
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Sorry but resume with uuid" + uuid + " is apsend!");
            return null;
        }

        return storage[index];
    }

    @Override
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

    @Override
    public int size() {
        return size;
    }


    protected abstract int getIndex(String uuid);
}
