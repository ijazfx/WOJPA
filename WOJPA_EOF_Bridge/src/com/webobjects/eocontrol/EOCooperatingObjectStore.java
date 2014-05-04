package com.webobjects.eocontrol;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

public class EOCooperatingObjectStore extends EOObjectStore {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void lock() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub

	}

	@Override
	public EOEnterpriseObject faultForGlobalID(EOGlobalID gid, EOEditingContext editingContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EOEnterpriseObject faultForRawRow(NSDictionary<String, ?> row, String entityName, EOEditingContext editingContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NSArray<? extends EOEnterpriseObject> arrayFaultWithSourceGlobalID(EOGlobalID gid, String entityName, EOEditingContext editingContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initializeObject(EOEnterpriseObject eo, EOGlobalID gid, EOEditingContext editingContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editingContextDidForgetObjectWithGlobalID(EOEditingContext editingContext, EOGlobalID gid) {
		// TODO Auto-generated method stub

	}

	@Override
	public NSArray<? extends EOEnterpriseObject> objectsForSourceGlobalID(EOGlobalID gid, String entityName, EOEditingContext editingContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refaultObject(EOEnterpriseObject eo, EOGlobalID gid, EOEditingContext editingContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveChangesInEditingContext(EOEditingContext editingContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public NSArray<? extends EOEnterpriseObject> objectsWithFetchSpecification(EOFetchSpecification fs, EOEditingContext editingContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isObjectLockedWithGlobalID(EOGlobalID gid, EOEditingContext editingContext) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void lockObjectWithGlobalID(EOGlobalID gid, EOEditingContext editingContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void invalidateAllObjects() {
		// TODO Auto-generated method stub

	}

	@Override
	public void invalidateObjectsWithGlobalIDs(NSArray<EOGlobalID> gids) {
		// TODO Auto-generated method stub

	}

}
