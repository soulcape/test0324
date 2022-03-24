package com.kk;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksIterator;


public class rocksdbTest {
    static{
        RocksDB.loadLibrary();
    }
    static RocksDB rocksDB;
    public static void main(String[] args) throws Exception {
        Options options = new Options();
//        options.setCreateIfMissing(true);
        rocksDB = RocksDB.open(options, args[0]);
        RocksIterator iter = rocksDB.newIterator();
        for(iter.seekToFirst(); iter.isValid(); iter.next()) {
            System.out.println("iter key:" + new String(iter.key()) + ", iter value:" + new String(iter.value()));
        }

    }
}
