package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        super.save(r);
    }

    @Override
    public void delete(String uuid) {
        super.delete(uuid);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void update(Resume r) {
        super.update(r);
    }


    @Override
    public Resume get(String uuid) {
        return super.get(uuid);
    }


    @Override
    public Resume[] getAll() {
        return super.getAll();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}
