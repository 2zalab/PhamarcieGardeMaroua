package com.maroua.pharmaciegarde.data.local.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PharmacyDao_Impl implements PharmacyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PharmacyEntity> __insertionAdapterOfPharmacyEntity;

  private final EntityDeletionOrUpdateAdapter<PharmacyEntity> __deletionAdapterOfPharmacyEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPharmacies;

  public PharmacyDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPharmacyEntity = new EntityInsertionAdapter<PharmacyEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `pharmacies` (`id`,`name`,`address`,`phone`,`phoneSecondary`,`latitude`,`longitude`,`imageUrl`,`description`,`city`,`district`,`hasParking`,`hasWheelchairAccess`,`is24Hours`,`isActive`,`lastUpdated`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final PharmacyEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAddress());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        if (entity.getPhoneSecondary() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPhoneSecondary());
        }
        statement.bindDouble(6, entity.getLatitude());
        statement.bindDouble(7, entity.getLongitude());
        if (entity.getImageUrl() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getImageUrl());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDescription());
        }
        if (entity.getCity() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getCity());
        }
        if (entity.getDistrict() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getDistrict());
        }
        final int _tmp = entity.getHasParking() ? 1 : 0;
        statement.bindLong(12, _tmp);
        final int _tmp_1 = entity.getHasWheelchairAccess() ? 1 : 0;
        statement.bindLong(13, _tmp_1);
        final int _tmp_2 = entity.is24Hours() ? 1 : 0;
        statement.bindLong(14, _tmp_2);
        final int _tmp_3 = entity.isActive() ? 1 : 0;
        statement.bindLong(15, _tmp_3);
        statement.bindLong(16, entity.getLastUpdated());
      }
    };
    this.__deletionAdapterOfPharmacyEntity = new EntityDeletionOrUpdateAdapter<PharmacyEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `pharmacies` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final PharmacyEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAllPharmacies = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM pharmacies";
        return _query;
      }
    };
  }

  @Override
  public Object insertPharmacies(final List<PharmacyEntity> pharmacies,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPharmacyEntity.insert(pharmacies);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertPharmacy(final PharmacyEntity pharmacy,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPharmacyEntity.insert(pharmacy);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePharmacy(final PharmacyEntity pharmacy,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPharmacyEntity.handle(pharmacy);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllPharmacies(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPharmacies.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllPharmacies.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PharmacyEntity>> getAllPharmacies() {
    final String _sql = "SELECT * FROM pharmacies WHERE isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pharmacies"}, new Callable<List<PharmacyEntity>>() {
      @Override
      @NonNull
      public List<PharmacyEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneSecondary = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneSecondary");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfDistrict = CursorUtil.getColumnIndexOrThrow(_cursor, "district");
          final int _cursorIndexOfHasParking = CursorUtil.getColumnIndexOrThrow(_cursor, "hasParking");
          final int _cursorIndexOfHasWheelchairAccess = CursorUtil.getColumnIndexOrThrow(_cursor, "hasWheelchairAccess");
          final int _cursorIndexOfIs24Hours = CursorUtil.getColumnIndexOrThrow(_cursor, "is24Hours");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final List<PharmacyEntity> _result = new ArrayList<PharmacyEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PharmacyEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneSecondary;
            if (_cursor.isNull(_cursorIndexOfPhoneSecondary)) {
              _tmpPhoneSecondary = null;
            } else {
              _tmpPhoneSecondary = _cursor.getString(_cursorIndexOfPhoneSecondary);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpDistrict;
            if (_cursor.isNull(_cursorIndexOfDistrict)) {
              _tmpDistrict = null;
            } else {
              _tmpDistrict = _cursor.getString(_cursorIndexOfDistrict);
            }
            final boolean _tmpHasParking;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfHasParking);
            _tmpHasParking = _tmp != 0;
            final boolean _tmpHasWheelchairAccess;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHasWheelchairAccess);
            _tmpHasWheelchairAccess = _tmp_1 != 0;
            final boolean _tmpIs24Hours;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIs24Hours);
            _tmpIs24Hours = _tmp_2 != 0;
            final boolean _tmpIsActive;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_3 != 0;
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _item = new PharmacyEntity(_tmpId,_tmpName,_tmpAddress,_tmpPhone,_tmpPhoneSecondary,_tmpLatitude,_tmpLongitude,_tmpImageUrl,_tmpDescription,_tmpCity,_tmpDistrict,_tmpHasParking,_tmpHasWheelchairAccess,_tmpIs24Hours,_tmpIsActive,_tmpLastUpdated);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getPharmacyById(final int pharmacyId,
      final Continuation<? super PharmacyEntity> $completion) {
    final String _sql = "SELECT * FROM pharmacies WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pharmacyId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PharmacyEntity>() {
      @Override
      @Nullable
      public PharmacyEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneSecondary = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneSecondary");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfDistrict = CursorUtil.getColumnIndexOrThrow(_cursor, "district");
          final int _cursorIndexOfHasParking = CursorUtil.getColumnIndexOrThrow(_cursor, "hasParking");
          final int _cursorIndexOfHasWheelchairAccess = CursorUtil.getColumnIndexOrThrow(_cursor, "hasWheelchairAccess");
          final int _cursorIndexOfIs24Hours = CursorUtil.getColumnIndexOrThrow(_cursor, "is24Hours");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final PharmacyEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneSecondary;
            if (_cursor.isNull(_cursorIndexOfPhoneSecondary)) {
              _tmpPhoneSecondary = null;
            } else {
              _tmpPhoneSecondary = _cursor.getString(_cursorIndexOfPhoneSecondary);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpDistrict;
            if (_cursor.isNull(_cursorIndexOfDistrict)) {
              _tmpDistrict = null;
            } else {
              _tmpDistrict = _cursor.getString(_cursorIndexOfDistrict);
            }
            final boolean _tmpHasParking;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfHasParking);
            _tmpHasParking = _tmp != 0;
            final boolean _tmpHasWheelchairAccess;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHasWheelchairAccess);
            _tmpHasWheelchairAccess = _tmp_1 != 0;
            final boolean _tmpIs24Hours;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIs24Hours);
            _tmpIs24Hours = _tmp_2 != 0;
            final boolean _tmpIsActive;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_3 != 0;
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _result = new PharmacyEntity(_tmpId,_tmpName,_tmpAddress,_tmpPhone,_tmpPhoneSecondary,_tmpLatitude,_tmpLongitude,_tmpImageUrl,_tmpDescription,_tmpCity,_tmpDistrict,_tmpHasParking,_tmpHasWheelchairAccess,_tmpIs24Hours,_tmpIsActive,_tmpLastUpdated);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PharmacyEntity>> searchPharmacies(final String query) {
    final String _sql = "SELECT * FROM pharmacies WHERE name LIKE '%' || ? || '%' OR address LIKE '%' || ? || '%' OR district LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pharmacies"}, new Callable<List<PharmacyEntity>>() {
      @Override
      @NonNull
      public List<PharmacyEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneSecondary = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneSecondary");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfDistrict = CursorUtil.getColumnIndexOrThrow(_cursor, "district");
          final int _cursorIndexOfHasParking = CursorUtil.getColumnIndexOrThrow(_cursor, "hasParking");
          final int _cursorIndexOfHasWheelchairAccess = CursorUtil.getColumnIndexOrThrow(_cursor, "hasWheelchairAccess");
          final int _cursorIndexOfIs24Hours = CursorUtil.getColumnIndexOrThrow(_cursor, "is24Hours");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final List<PharmacyEntity> _result = new ArrayList<PharmacyEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PharmacyEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneSecondary;
            if (_cursor.isNull(_cursorIndexOfPhoneSecondary)) {
              _tmpPhoneSecondary = null;
            } else {
              _tmpPhoneSecondary = _cursor.getString(_cursorIndexOfPhoneSecondary);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpDistrict;
            if (_cursor.isNull(_cursorIndexOfDistrict)) {
              _tmpDistrict = null;
            } else {
              _tmpDistrict = _cursor.getString(_cursorIndexOfDistrict);
            }
            final boolean _tmpHasParking;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfHasParking);
            _tmpHasParking = _tmp != 0;
            final boolean _tmpHasWheelchairAccess;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHasWheelchairAccess);
            _tmpHasWheelchairAccess = _tmp_1 != 0;
            final boolean _tmpIs24Hours;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIs24Hours);
            _tmpIs24Hours = _tmp_2 != 0;
            final boolean _tmpIsActive;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_3 != 0;
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _item = new PharmacyEntity(_tmpId,_tmpName,_tmpAddress,_tmpPhone,_tmpPhoneSecondary,_tmpLatitude,_tmpLongitude,_tmpImageUrl,_tmpDescription,_tmpCity,_tmpDistrict,_tmpHasParking,_tmpHasWheelchairAccess,_tmpIs24Hours,_tmpIsActive,_tmpLastUpdated);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<PharmacyEntity>> getFavoritePharmacies(final List<Integer> ids) {
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM pharmacies WHERE id IN (");
    final int _inputSize = ids.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : ids) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex++;
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pharmacies"}, new Callable<List<PharmacyEntity>>() {
      @Override
      @NonNull
      public List<PharmacyEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfPhoneSecondary = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneSecondary");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfDistrict = CursorUtil.getColumnIndexOrThrow(_cursor, "district");
          final int _cursorIndexOfHasParking = CursorUtil.getColumnIndexOrThrow(_cursor, "hasParking");
          final int _cursorIndexOfHasWheelchairAccess = CursorUtil.getColumnIndexOrThrow(_cursor, "hasWheelchairAccess");
          final int _cursorIndexOfIs24Hours = CursorUtil.getColumnIndexOrThrow(_cursor, "is24Hours");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final List<PharmacyEntity> _result = new ArrayList<PharmacyEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PharmacyEntity _item_1;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpPhoneSecondary;
            if (_cursor.isNull(_cursorIndexOfPhoneSecondary)) {
              _tmpPhoneSecondary = null;
            } else {
              _tmpPhoneSecondary = _cursor.getString(_cursorIndexOfPhoneSecondary);
            }
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpDistrict;
            if (_cursor.isNull(_cursorIndexOfDistrict)) {
              _tmpDistrict = null;
            } else {
              _tmpDistrict = _cursor.getString(_cursorIndexOfDistrict);
            }
            final boolean _tmpHasParking;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfHasParking);
            _tmpHasParking = _tmp != 0;
            final boolean _tmpHasWheelchairAccess;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHasWheelchairAccess);
            _tmpHasWheelchairAccess = _tmp_1 != 0;
            final boolean _tmpIs24Hours;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIs24Hours);
            _tmpIs24Hours = _tmp_2 != 0;
            final boolean _tmpIsActive;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_3 != 0;
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _item_1 = new PharmacyEntity(_tmpId,_tmpName,_tmpAddress,_tmpPhone,_tmpPhoneSecondary,_tmpLatitude,_tmpLongitude,_tmpImageUrl,_tmpDescription,_tmpCity,_tmpDistrict,_tmpHasParking,_tmpHasWheelchairAccess,_tmpIs24Hours,_tmpIsActive,_tmpLastUpdated);
            _result.add(_item_1);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
