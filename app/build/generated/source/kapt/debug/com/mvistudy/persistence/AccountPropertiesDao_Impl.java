package com.mvistudy.persistence;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mvistudy.models.AccountProperties;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AccountPropertiesDao_Impl implements AccountPropertiesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AccountProperties> __insertionAdapterOfAccountProperties;

  private final EntityInsertionAdapter<AccountProperties> __insertionAdapterOfAccountProperties_1;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAccountProperties;

  public AccountPropertiesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAccountProperties = new EntityInsertionAdapter<AccountProperties>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `account_properties` (`pk`,`email`,`username`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AccountProperties value) {
        stmt.bindLong(1, value.getPk());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUsername());
        }
      }
    };
    this.__insertionAdapterOfAccountProperties_1 = new EntityInsertionAdapter<AccountProperties>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `account_properties` (`pk`,`email`,`username`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AccountProperties value) {
        stmt.bindLong(1, value.getPk());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUsername());
        }
      }
    };
    this.__preparedStmtOfUpdateAccountProperties = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE account_properties SET email = ?, username = ? WHERE pk = ?";
        return _query;
      }
    };
  }

  @Override
  public long insertAndReplace(final AccountProperties accountProperties) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAccountProperties.insertAndReturnId(accountProperties);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertOrIgnore(final AccountProperties accountProperties) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAccountProperties_1.insertAndReturnId(accountProperties);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAccountProperties(final int pk, final String email, final String username) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAccountProperties.acquire();
    int _argIndex = 1;
    if (email == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (username == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, username);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, pk);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAccountProperties.release(_stmt);
    }
  }

  @Override
  public AccountProperties searchByEmail(final String email) {
    final String _sql = "SELECT * FROM account_properties WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPk = CursorUtil.getColumnIndexOrThrow(_cursor, "pk");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final AccountProperties _result;
      if(_cursor.moveToFirst()) {
        final int _tmpPk;
        _tmpPk = _cursor.getInt(_cursorIndexOfPk);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result = new AccountProperties(_tmpPk,_tmpEmail,_tmpUsername);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AccountProperties searchByPk(final int pk) {
    final String _sql = "SELECT * FROM account_properties WHERE pk = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pk);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPk = CursorUtil.getColumnIndexOrThrow(_cursor, "pk");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final AccountProperties _result;
      if(_cursor.moveToFirst()) {
        final int _tmpPk;
        _tmpPk = _cursor.getInt(_cursorIndexOfPk);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result = new AccountProperties(_tmpPk,_tmpEmail,_tmpUsername);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
