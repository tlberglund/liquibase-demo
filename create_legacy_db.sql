CREATE TABLE `scinventoryrecord` (
  `id` int(11) NOT NULL,
  `supplierid` int(11) NOT NULL,
  `pn` varchar(50) character set latin1 collate latin1_bin NOT NULL,
  `nativepn` varchar(50) character set latin1 collate latin1_bin NOT NULL,
  `familyid` int(11) default NULL,
  `availabletosell` int(11) NOT NULL,
  `minimumorder` int(11) default NULL,
  `cost` varchar(50) NOT NULL,
  `pref` decimal(10,9) NOT NULL,
  `packageqty` int(11) default NULL,
  `prefcategory` int(11) NOT NULL,
  `active` int(1) default NULL,
  `timestamp` datetime NOT NULL,
  `suppliercode` varchar(50) NOT NULL,
  `flags` int(11) NOT NULL,
  `incontent` int(1) default NULL,
  `aliases` varchar(255) default NULL,
  `weight` decimal(14,8) default NULL,
  `filteredpn` varchar(50) character set latin1 collate latin1_bin default NULL,
  PRIMARY KEY  (`pn`,`suppliercode`,`supplierid`),
  UNIQUE KEY `sys_c0035302` (`id`),
  KEY `util_db_fk_1669632842` (`supplierid`)
) ENGINE=InnoDB;

CREATE TABLE `scinventoryrecordparm` (
  `inventoryrecordid` int(11) NOT NULL,
  `parmid` int(11) NOT NULL,
  `value` decimal(20,10) NOT NULL,
  PRIMARY KEY  (`inventoryrecordid`,`parmid`),
  KEY `SCInventoryRecordParmindex` (`parmid`,`value`),
  KEY `util_db_fk_565312195` (`inventoryrecordid`),
  CONSTRAINT `SCInventoryRecordParm__SCInventoryRecord_id` FOREIGN KEY (`inventoryrecordid`) REFERENCES `scinventoryrecord` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE `scproject` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `creationdate` datetime default NULL,
  `filetype` int(11) default NULL,
  `fileheaderrownum` int(11) default NULL,
  `sheetname` varchar(50) default NULL,
  UNIQUE KEY `sys_c0035279` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `sclineitem` (
  `id` int(11) NOT NULL auto_increment,
  `projectid` int(11) NOT NULL,
  `rownumber` int(11) NOT NULL,
  `requestedquantity` int(11) default NULL,
  `description` varchar(1000) character set latin1 collate latin1_bin default NULL,
  `requestedpn` varchar(1000) character set latin1 collate latin1_bin default NULL,
  `requestedmfg` varchar(1000) character set latin1 collate latin1_bin default NULL,
  `internalcustomerpn` varchar(50) default NULL,
  `parsedfamilyid` int(11) default NULL,
  `parsedmfgid` int(11) default NULL,
  `parsedpn` varchar(50) default NULL,
  `scrubstatus` int(11) default NULL,
  `parsedconfidence` int(11) default NULL,
  `scrubduration` int(11) default NULL,
  PRIMARY KEY  (`rownumber`,`projectid`),
  UNIQUE KEY `sys_c0035282` (`id`),
  KEY `sys_c0035358` (`projectid`),
  CONSTRAINT `SCLineItem__SCProject_id` FOREIGN KEY (`projectid`) REFERENCES `scproject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE `sclineiteminventoryrecord` (
  `projectid` int(11) default NULL,
  `id` int(11) NOT NULL auto_increment,
  `lineitemid` int(11) NOT NULL,
  `inventoryrecordid` int(11) NOT NULL,
  `matchquality` decimal(10,9) default NULL,
  PRIMARY KEY  (`inventoryrecordid`,`lineitemid`),
  UNIQUE KEY `sys_c0035306` (`id`),
  KEY `sys_c0035383` (`projectid`),
  KEY `sys_c0035384` (`lineitemid`),
  CONSTRAINT `SCLineItemInventoryRecord__SCInventoryRecord_id` FOREIGN KEY (`inventoryrecordid`) REFERENCES `scinventoryrecord` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SCLineItemInventoryRecord__SCLineItem_id` FOREIGN KEY (`lineitemid`) REFERENCES `sclineitem` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SCLineItemInventoryRecord__SCProject_id` FOREIGN KEY (`projectid`) REFERENCES `SCProject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE `scpnparseentry` (
  `pn` varchar(50) default NULL,
  `id` int(11) NOT NULL auto_increment,
  `projectid` int(11) NOT NULL,
  `rownumber` int(11) NOT NULL,
  PRIMARY KEY  (`rownumber`,`projectid`),
  UNIQUE KEY `sys_c0035286` (`id`),
  KEY `sys_c0035360` (`projectid`,`rownumber`),
  CONSTRAINT `SCPNParseEntry__SCLineItem__projectID_rowNumber` FOREIGN KEY (`projectid`, `rownumber`) REFERENCES `sclineitem` (`projectid`, `rownumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE `scpnparseentryparm` (
  `id` int(11) NOT NULL auto_increment,
  `projectid` int(11) default NULL,
  `pnparseentryid` int(11) default NULL,
  `parmid` int(11) default NULL,
  `valueid` int(11) default NULL,
  `valuedouble` decimal(20,8) default NULL,
  UNIQUE KEY `sys_c0035287` (`id`),
  KEY `util_db_fk_231461879` (`pnparseentryid`),
  KEY `sys_c0035362` (`projectid`),
  CONSTRAINT `SCPNParseEntryParm__SCPNParseEntry_id` FOREIGN KEY (`pnparseentryid`) REFERENCES `scpnparseentry` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SCPNParseEntryParm__SCProject_id` FOREIGN KEY (`projectid`) REFERENCES `scproject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE `scpnqueryentry` (
  `pn` varchar(50) default NULL,
  `id` int(11) NOT NULL auto_increment,
  `projectid` int(11) NOT NULL,
  `rownumber` int(11) NOT NULL,
  PRIMARY KEY  (`projectid`,`rownumber`),
  UNIQUE KEY `sys_c0035288` (`id`),
  CONSTRAINT `SCPNQueryEntry__SCLineItem_projectID_rowNumber` FOREIGN KEY (`projectid`, `rownumber`) REFERENCES `sclineitem` (`projectid`, `rownumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE `scregistrationwarehouse` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) character set latin1 collate latin1_bin default NULL,
  `registrationdate` datetime default NULL,
  `registrationip` varchar(50) default NULL,
  UNIQUE KEY `sys_c0035349` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `scscrubrecordwarehouse` (
  `id` int(11) NOT NULL auto_increment,
  `description` varchar(1000) character set latin1 collate latin1_bin default NULL,
  `pn` varchar(1000) character set latin1 collate latin1_bin default NULL,
  `timestamp` datetime default NULL,
  UNIQUE KEY `sys_c0035339` (`id`)
) ENGINE=InnoDB;

CREATE TABLE `scuser` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) character set latin1 collate latin1_bin default NULL,
  `password` varchar(50) character set latin1 collate latin1_bin default NULL,
  `emailaddress` varchar(50) character set latin1 collate latin1_bin default NULL,
  `firstname` varchar(50) default NULL,
  `lastname` varchar(50) default NULL,
  `adminprivilege` int(1) default NULL,
  `temporary` int(1) default NULL,
  `lastip` varchar(50) default NULL,
  `lastlogin` datetime default NULL,
  `cartid` int(11) default NULL,
  `sortby` int(11) default NULL,
  `showonlymfgmatches` int(1) default NULL,
  `showonlynonzeroinventory` int(1) default NULL,
  `validated` int(1) default NULL,
  `validationkey` varchar(50) default NULL,
  `optedin` int(11) default NULL,
  `phonenumber` varchar(50) default NULL,
  `company` varchar(50) default NULL,
  UNIQUE KEY `sys_c0035276` (`id`),
  UNIQUE KEY `sys_c0035277` (`username`),
  UNIQUE KEY `sys_c0035278` (`emailaddress`)
) ENGINE=InnoDB;

CREATE TABLE `scshoppingcart` (
  `id` int(11) NOT NULL auto_increment,
  `userid` int(11) NOT NULL,
  `lastmodified` datetime default NULL,
  `name` varchar(50) default NULL,
  UNIQUE KEY `sys_c0035318` (`id`),
  KEY `sys_c0035391` (`userid`),
  CONSTRAINT `SCShoppingCart__SCUser_id` FOREIGN KEY (`userid`) REFERENCES `scuser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE TABLE `scsuppliedparm` (
  `id` int(11) NOT NULL auto_increment,
  `projectid` int(11) default NULL,
  `rownumber` int(11) default NULL,
  `parmid` int(11) default NULL,
  `valueid` int(11) default NULL,
  `valuedouble` decimal(20,8) default NULL,
  UNIQUE KEY `sys_c0035284` (`id`),
  KEY `util_db_fk_1479464417` (`projectid`,`rownumber`),
  CONSTRAINT `SCSuppliedParm__SCLineItem_projectID_rowNumber` FOREIGN KEY (`projectid`, `rownumber`) REFERENCES `sclineitem` (`projectid`, `rownumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;


