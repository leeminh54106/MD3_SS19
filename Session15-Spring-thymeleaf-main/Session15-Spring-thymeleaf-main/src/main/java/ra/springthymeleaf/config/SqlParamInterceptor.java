package ra.springthymeleaf.config;


import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;

import java.io.Serializable;


public class SqlParamInterceptor extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("SQL Statement: " + sql);
        return super.onPrepareStatement(sql);
    }
    @Override
    public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
        System.out.println("Collection Update: " + collection);
        super.onCollectionUpdate(collection, key);
    }

    @Override
    public void beforeTransactionCompletion(Transaction tx) {
        System.out.println("Before Transaction Completion");
        super.beforeTransactionCompletion(tx);
    }

}

