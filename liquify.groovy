#!/usr/bin/env groovy

def liquibaseCmd = 'java -jar lib/liquibase-1.9.0.jar'

if(args.size() == 1 && args[0][0..1] == '--') {
	switch(args[0]) {
		case '--help':
			println """
Liquibase Utility Script
Copyright © 2009 August Technology Group, LLC

NAME
\tliquify - a script that makes running Liquibase less painful

SYNOPSIS
\tliquify command [liquibase switches]

DESCRIPTION
\tliquify executes the specified Liquibase against the database described
\tin the liquibase.properties file found in the current directory.  Any of
\tthe settings in the properties files can be overridden by specifying them
\tas Liquibase command line switches on the liquify command line.

PARAMETERS
\tcommand - The Liquibase command to execute. Run 'liquify --options' for 
\t   details.
"""
			break;
			
		case '--options':
			println liquibaseCmd.execute().text
			break;
	}
}
else if(args.size() == 0) {
	println "usage:\tliquify <command>"
	println "ex:\tliquify update"
	println "\tliquify generateChangeLog"
	println "\tliquify --help"
	println "\tliquify --options"
}
else {
	def liquibaseCommand = args[0]
	
	def defaultsFile = "liquibase.properties"

	def properties = new Properties()
	properties.load(new FileInputStream(defaultsFile))
	def options = getOptions(args)
	def password = properties.getProperty('password')
	if(!password) {
		password = options.password
		if(!password) {
			print "ENTER DATABASE PASSWORD: "
			password = new BufferedReader(new InputStreamReader(System.in)).readLine()
		}
	}

	def command = "${liquibaseCmd} --defaultsFile=${defaultsFile} --password=${password} ${args.size() > 1 ? args[1..-1].join(' ') : ''} ${liquibaseCommand}"
	println command
	def process = command.execute()
	process.consumeProcessOutput(System.out, System.err)
}


def getOptions(args) {
	def options = [:]
	if(args.size() > 3) {
		args[3..-1].each { arg ->
			if(arg[0..1] == '--') {
				def parts = arg[2..-1].tokenize('=')
				options[parts[0]] = parts[1] ? parts[1] : ''
			}
		}
	}
	
	return options
}