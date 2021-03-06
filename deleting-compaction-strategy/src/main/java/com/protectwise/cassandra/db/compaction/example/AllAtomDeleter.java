/*
 * Copyright 2015 ProtectWise, Inc.  All rights reserved
 * Unauthorized copying of this file by any means is strictly prohibited.
 */
package com.protectwise.cassandra.db.compaction.example;

import com.protectwise.cassandra.db.compaction.AbstractClusterDeletingConvictor;
import com.protectwise.cassandra.db.compaction.AbstractSimpleDeletingConvictor;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.OnDiskAtom;
import org.apache.cassandra.db.columniterator.OnDiskAtomIterator;
import org.apache.cassandra.db.composites.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class AllAtomDeleter extends AbstractSimpleDeletingConvictor
{
	private static final Logger logger = LoggerFactory.getLogger(AllAtomDeleter.class);

	/**
	 * @param cfs
	 * @param options
	 */
	public AllAtomDeleter(ColumnFamilyStore cfs, Map<String, String> options)
	{
		super(cfs, options);
		logger.warn("You are using an example deleting compaction strategy.  Direct production use of these classes is STRONGLY DISCOURAGED!");
	}

	@Override
	public boolean shouldKeepAtom(OnDiskAtomIterator partition, OnDiskAtom atom)
	{
		return false;
	}

	@Override
	public boolean shouldKeepPartition(OnDiskAtomIterator key)
	{
		return true;
	}
}

