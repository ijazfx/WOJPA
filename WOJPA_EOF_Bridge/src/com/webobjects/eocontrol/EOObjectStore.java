package com.webobjects.eocontrol;

import java.util.HashMap;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSDisposable;
import com.webobjects.foundation.NSLocking;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation._NSUtilities;

/**
 * The class has been re-implemented supporting generics.
 * 
 * @author ijazfx
 */
public abstract class EOObjectStore implements NSDisposable, NSLocking {

	public static final Class<?> _CLASS;
	public static final String ObjectsChangedInStoreNotification = "EOObjectsChangedInStoreNotification";
	public static final String InvalidatedAllObjectsInStoreNotification = "EOInvalidatedAllObjectsInStoreNotification";
	public static final String InsertedKey = "inserted";
	public static final String UpdatedKey = "updated";
	public static final String DeletedKey = "deleted";
	public static final String InvalidatedKey = "invalidated";
	protected static volatile boolean _doAssertLockInitialized;
	protected static volatile boolean _doAssertLock;
	protected volatile boolean _wasDisposed;
	protected volatile java.util.Map<String, Object> _userInfo;

	static {
		_CLASS = _NSUtilities._classWithFullySpecifiedName("com.webobjects.eocontrol.EOObjectStore");
		_doAssertLockInitialized = false;
		_doAssertLock = true;
	}

	public EOObjectStore() {
	}

	public abstract EOEnterpriseObject faultForGlobalID(EOGlobalID gid, EOEditingContext editingContext);

	public abstract EOEnterpriseObject faultForRawRow(NSDictionary<String, ?> row, String entityName, EOEditingContext editingContext);

	public abstract NSArray<? extends EOEnterpriseObject> arrayFaultWithSourceGlobalID(EOGlobalID gid, String entityName, EOEditingContext editingContext);

	public abstract void initializeObject(EOEnterpriseObject eo, EOGlobalID gid, EOEditingContext editingContext);

	public abstract void editingContextDidForgetObjectWithGlobalID(EOEditingContext editingContext, EOGlobalID gid);

	public abstract NSArray<? extends EOEnterpriseObject> objectsForSourceGlobalID(EOGlobalID gid, String entityName, EOEditingContext editingContext);

	public abstract void refaultObject(EOEnterpriseObject eo, EOGlobalID gid, EOEditingContext editingContext);

	public abstract void saveChangesInEditingContext(EOEditingContext editingContext);

	public abstract NSArray<? extends EOEnterpriseObject> objectsWithFetchSpecification(EOFetchSpecification fs, EOEditingContext editingContext);

	public abstract boolean isObjectLockedWithGlobalID(EOGlobalID gid, EOEditingContext editingContext);

	public abstract void lockObjectWithGlobalID(EOGlobalID gid, EOEditingContext editingContext);

	public abstract void invalidateAllObjects();

	public abstract void invalidateObjectsWithGlobalIDs(NSArray<EOGlobalID> gids);

	public Object invokeRemoteMethod(EOEditingContext editingContext, EOGlobalID gid, String entityName, Class<?>[] klasses, Object[] objects) {
		String message = "Cannot perform remote method invocation with object store of class " + getClass().getName();
		throw new IllegalStateException(message);
	}

	public abstract void lock();

	public abstract void unlock();

	public void dispose() {
		if (_wasDisposed) {
			String message = getClass().getName() + ".dispose() invoked on already disposed object [#" + System.identityHashCode(this) + "]";
			throw new IllegalStateException(message);
		}
		_wasDisposed = true;
	}

	protected boolean _invalidateObjectsDuringSave() {
		return false;
	}

	public static void _suppressAssertLock() {
		_doAssertLock = false;
		_doAssertLockInitialized = true;
	}

	public static void _resetAssertLock() {
		_doAssertLock = true;
		_doAssertLockInitialized = false;
	}

	protected static void _checkAssertLock() {
		if (!_doAssertLockInitialized) {
			_doAssertLock = NSLog.debugLoggingAllowedForLevel(NSLog.DebugLevelInformational);
			_doAssertLockInitialized = true;
		}
	}

	public void setUserInfo(java.util.Map<String, Object> userInfo) {
		if (userInfo == null) {
			_userInfo = new HashMap<String, Object>();
		} else {
			_userInfo = new HashMap<String, Object>(userInfo);
		}
	}

	public NSDictionary<String, Object> userInfo() {
		if (_userInfo == null) {
			return new NSDictionary<String, Object>();
		}
		return new NSDictionary<String, Object>(_userInfo);
	}

	public Object userInfoForKey(String key) {
		if (_userInfo == null) {
			_userInfo = new HashMap<String, Object>();
		}
		return _userInfo.get(key);
	}

	public void setUserInfoForKey(Object value, String key) {
		if (_userInfo == null) {
			_userInfo = new HashMap<String, Object>();
		}
		if (value == null) {
			_userInfo.remove(key);
		} else {
			_userInfo.put(key, value);
		}
	}

}
