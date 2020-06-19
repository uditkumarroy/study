package com.mvistudy.persistence;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mvistudy.models.AuthToken;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AuthTokenDao_Impl implements AuthTokenDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AuthToken> __insertionAdapterOfAuthToken;

  private final SharedSQLiteStatement __preparedStmtOfNullifyToken;

  public AuthTokenDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAuthToken = new EntityInsertionAdapter<AuthToken>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `auth_token` (`account_pk`,`token`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AuthToken value) {
        if (value.getAccount_pk() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getAccount_pk());
        }
        if (value.getToken() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getToken());
        }
      }
    };
    this.__preparedStmtOfNullifyToken = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE auth_token SET token = null WHERE account_pk = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final AuthToken authToken, final Continuation<? super Long> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfAuthToken.insertAndReturnId(authToken);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object nullifyToken(final int pk, final Continuation<? super Integer> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfNullifyToken.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, pk);
        __db.beginTransaction();
        try {
          final java.lang.Integer _result = _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
          __preparedStmtOfNullifyToken.release(_stmt);
        }
      }
    }, p1);
  }

  @Override
  public Object searchByPk(final int pk, final Continuation<? super AuthToken> p1) {
    final String _sql = "SELECT * FROM auth_token WHERE account_pk = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pk);
    return CoroutinesRoom.execute(__db, false, new Callable<AuthToken>() {
      @Override
      public AuthToken call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAccountPk = CursorUtil.getColumnIndexOrThrow(_cursor, "account_pk");
          final int _cursorIndexOfToken = CursorUtil.getColumnIndexOrThrow(_cursor, "token");
          final AuthToken _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmpAccount_pk;
            if (_cursor.isNull(_cursorIndexOfAccountPk)) {
              _tmpAccount_pk = null;
            } else {
              _tmpAccount_pk = _cursor.getInt(_cursorIndexOfAccountPk);
            }
            final String _tmpToken;
            _tmpToken = _cursor.getString(_cursorIndexOfToken);
            _result = new AuthToken(_tmpAccount_pk,_tmpToken);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }
}
