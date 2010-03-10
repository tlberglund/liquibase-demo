changeSet( author: "tlberglund (generated)", id: "1256717380236-1" ){
	createTable( tableName: "inventory_record" ) {
		column( name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "supplierid", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "pn", type: "VARCHAR(50)" ) {
			constraints( nullable: "false" )
		}
		column( name: "nativepn", type: "VARCHAR(50)" ) {
			constraints( nullable: "false" )
		}
		column( name: "familyid", type: "INT" )
		column( name: "availabletosell", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "minimumorder", type: "INT" )
		column( name: "cost", type: "VARCHAR(50)" ) {
			constraints( nullable: "false" )
		}
		column( name: "pref", type: "decimal(10,9)" ) {
			constraints( nullable: "false" )
		}
		column( name: "packageqty", type: "INT" )
		column( name: "prefcategory", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "active", type: "INT" )
		column( name: "timestamp", type: "DATETIME" ) {
			constraints( nullable: "false" )
		}
		column( name: "suppliercode", type: "VARCHAR(50)" ) {
			constraints( nullable: "false" )
		}
		column( name: "flags", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "incontent", type: "INT" )
		column( name: "aliases", type: "VARCHAR(255)" )
		column( name: "weight", type: "decimal(14,8)" )
		column( name: "filteredpn", type: "VARCHAR(50)" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-2" ){
	createTable( tableName: "inventory_record_parm" ) {
		column( name: "inventoryrecordid", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "parmid", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "value", type: "decimal(20,10)" ) {
			constraints( nullable: "false" )
		}
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-3" ){
	createTable( tableName: "line_item" ) {
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "projectid", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "rownumber", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "requestedquantity", type: "INT" )
		column( name: "description", type: "VARCHAR(1000)" )
		column( name: "requestedpn", type: "VARCHAR(1000)" )
		column( name: "requestedmfg", type: "VARCHAR(1000)" )
		column( name: "internalcustomerpn", type: "VARCHAR(50)" )
		column( name: "parsedfamilyid", type: "INT" )
		column( name: "parsedmfgid", type: "INT" )
		column( name: "parsedpn", type: "VARCHAR(50)" )
		column( name: "scrubstatus", type: "INT" )
		column( name: "parsedconfidence", type: "INT" )
		column( name: "scrubduration", type: "INT" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-4" ){
	createTable( tableName: "line_item_inventory_record" ) {
		column( name: "projectid", type: "INT" )
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "lineitemid", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "inventoryrecordid", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "matchquality", type: "decimal(10,9)" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-5" ){
	createTable( tableName: "pn_parse_entry" ) {
		column( name: "pn", type: "VARCHAR(50)" )
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "projectid", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "rownumber", type: "INT" ) {
			constraints( nullable: "false" )
		}
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-6" ){
	createTable( tableName: "pn_parse_entry_parm" ) {
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "projectid", type: "INT" )
		column( name: "pnparseentryid", type: "INT" )
		column( name: "parmid", type: "INT" )
		column( name: "valueid", type: "INT" )
		column( name: "valuedouble", type: "decimal(20,8)" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-7" ){
	createTable( tableName: "pn_query_entry" ) {
		column( name: "pn", type: "VARCHAR(50)" )
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "projectid", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "rownumber", type: "INT" ) {
			constraints( nullable: "false" )
		}
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-8" ){
	createTable( tableName: "project" ) {
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "name", type: "VARCHAR(50)" )
		column( name: "creationdate", type: "DATETIME" )
		column( name: "filetype", type: "INT" )
		column( name: "fileheaderrownum", type: "INT" )
		column( name: "sheetname", type: "VARCHAR(50)" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-9" ){
	createTable( tableName: "registration_log" ) {
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "username", type: "VARCHAR(50)" )
		column( name: "registrationdate", type: "DATETIME" )
		column( name: "registrationip", type: "VARCHAR(50)" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-10" ){
	createTable( tableName: "scrub_record_log" ) {
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "description", type: "VARCHAR(1000)" )
		column( name: "pn", type: "VARCHAR(1000)" )
		column( name: "timestamp", type: "DATETIME" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-11" ){
	createTable( tableName: "shopping_cart" ) {
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "userid", type: "INT" ) {
			constraints( nullable: "false" )
		}
		column( name: "lastmodified", type: "DATETIME" )
		column( name: "name", type: "VARCHAR(50)" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-12" ){
	createTable( tableName: "supplied_parm" ) {
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}

		column( name: "projectid", type: "INT" )
		column( name: "rownumber", type: "INT" )
		column( name: "parmid", type: "INT" )
		column( name: "valueid", type: "INT" )
		column( name: "valuedouble", type: "decimal(20,8)" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-13" ){
	createTable( tableName: "user" ) {
		column( autoIncrement: "true", name: "id", type: "INT" ) {
			constraints( nullable: "false" )
		}

		column( name: "username", type: "VARCHAR(50)" )
		column( name: "password", type: "VARCHAR(50)" )
		column( name: "emailaddress", type: "VARCHAR(50)" )
		column( name: "firstname", type: "VARCHAR(50)" )
		column( name: "lastname", type: "VARCHAR(50)" )
		column( name: "adminprivilege", type: "INT" )
		column( name: "temporary", type: "INT" )
		column( name: "lastip", type: "VARCHAR(50)" )
		column( name: "lastlogin", type: "DATETIME" )
		column( name: "cartid", type: "INT" )
		column( name: "sortby", type: "INT" )
		column( name: "showonlymfgmatches", type: "INT" )
		column( name: "showonlynonzeroinventory", type: "INT" )
		column( name: "validated", type: "INT" )
		column( name: "validationkey", type: "VARCHAR(50)" )
		column( name: "optedin", type: "INT" )
		column( name: "phonenumber", type: "VARCHAR(50)" )
		column( name: "company", type: "VARCHAR(50)" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-14" ){
	addPrimaryKey( columnNames: "pn, suppliercode, supplierid", tableName: "inventory_record" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-15" ){
	addPrimaryKey( columnNames: "inventoryrecordid, parmid", tableName: "inventory_record_parm" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-16" ){
	addPrimaryKey( columnNames: "rownumber, projectid", tableName: "line_item" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-17" ){
	addPrimaryKey( columnNames: "inventoryrecordid, lineitemid", tableName: "line_item_inventory_record" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-18" ){
	addPrimaryKey( columnNames: "rownumber, projectid", tableName: "pn_parse_entry" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-19" ){
	addPrimaryKey( columnNames: "projectid, rownumber", tableName: "pn_query_entry" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-20" ){
	createIndex( indexName: "sys_c0035302", tableName: "inventory_record", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-21" ){
	createIndex( indexName: "util_db_fk_1669632842", tableName: "inventory_record", unique: "false" ) {
		column( name: "supplierid" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-22" ){
	createIndex( indexName: "SCInventoryRecordParmindex", tableName: "inventory_record_parm", unique: "false" ) {
		column( name: "parmid" )
		column( name: "value" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-23" ){
	createIndex( indexName: "sys_c0035282", tableName: "line_item", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-24" ){
	createIndex( indexName: "sys_c0035306", tableName: "line_item_inventory_record", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-25" ){
	createIndex( indexName: "sys_c0035286", tableName: "pn_parse_entry", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-26" ){
	createIndex( indexName: "sys_c0035287", tableName: "pn_parse_entry_parm", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-27" ){
	createIndex( indexName: "sys_c0035288", tableName: "pn_query_entry", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-28" ){
	createIndex( indexName: "sys_c0035279", tableName: "project", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-29" ){
	createIndex( indexName: "sys_c0035349", tableName: "registration_log", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-30" ){
	createIndex( indexName: "sys_c0035339", tableName: "scrub_record_log", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-31" ){
	createIndex( indexName: "sys_c0035318", tableName: "shopping_cart", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-32" ){
	createIndex( indexName: "sys_c0035284", tableName: "supplied_parm", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-33" ){
	createIndex( indexName: "sys_c0035276", tableName: "user", unique: "true" ) {
		column( name: "id" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-34" ){
	createIndex( indexName: "sys_c0035277", tableName: "user", unique: "true" ) {
		column( name: "username" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-35" ){
	createIndex( indexName: "sys_c0035278", tableName: "user", unique: "true" ) {
		column( name: "emailaddress" )
	}
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-36" ){
	addForeignKeyConstraint( baseColumnNames: "inventoryrecordid", baseTableName: "inventory_record_parm", constraintName: "SCInventoryRecordParm__SCInventoryRecord_id", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "inventory_record" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-37" ){
	addForeignKeyConstraint( baseColumnNames: "projectid", baseTableName: "line_item", constraintName: "SCLineItem__SCProject_id", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "project" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-38" ){
	addForeignKeyConstraint( baseColumnNames: "inventoryrecordid", baseTableName: "line_item_inventory_record", constraintName: "SCLineItemInventoryRecord__SCInventoryRecord_id", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "inventory_record" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-39" ){
	addForeignKeyConstraint( baseColumnNames: "lineitemid", baseTableName: "line_item_inventory_record", constraintName: "SCLineItemInventoryRecord__SCLineItem_id", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "line_item" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-40" ){
	addForeignKeyConstraint( baseColumnNames: "projectid", baseTableName: "line_item_inventory_record", constraintName: "SCLineItemInventoryRecord__SCProject_id", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "project" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-41" ){
	addForeignKeyConstraint( baseColumnNames: "projectid, rownumber", baseTableName: "pn_parse_entry", constraintName: "SCPNParseEntry__SCLineItem__projectID_rowNumber", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "projectid, rownumber", referencedTableName: "line_item" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-42" ){
	addForeignKeyConstraint( baseColumnNames: "pnparseentryid", baseTableName: "pn_parse_entry_parm", constraintName: "SCPNParseEntryParm__SCPNParseEntry_id", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "pn_parse_entry" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-43" ){
	addForeignKeyConstraint( baseColumnNames: "projectid", baseTableName: "pn_parse_entry_parm", constraintName: "SCPNParseEntryParm__SCProject_id", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "project" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-44" ){
	addForeignKeyConstraint( baseColumnNames: "projectid, rownumber", baseTableName: "pn_query_entry", constraintName: "SCPNQueryEntry__SCLineItem_projectID_rowNumber", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "projectid, rownumber", referencedTableName: "line_item" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-45" ){
	addForeignKeyConstraint( baseColumnNames: "userid", baseTableName: "shopping_cart", constraintName: "SCShoppingCart__SCUser_id", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user" )
}

changeSet( author: "tlberglund (generated)", id: "1256717380236-46" ){
	addForeignKeyConstraint( baseColumnNames: "projectid, rownumber", baseTableName: "supplied_parm", constraintName: "SCSuppliedParm__SCLineItem_projectID_rowNumber", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "projectid, rownumber", referencedTableName: "line_item" )
}

