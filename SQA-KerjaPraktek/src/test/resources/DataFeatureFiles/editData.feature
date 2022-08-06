Feature: Edit Data Test

	Scenario: Valid Edit
		Given User login with username "developer" and password "23"
		When User get login message "Welcome to Tele Kita"
		And User click ok to the validate message
		And User move to table_Data
		And User move to table Edit Data
		And User select the earliest data
		And User update or edit the data
		And User confirm or click update button
		Then User see data changed successfully for earliest data
		
		
	Scenario: Valid Edit
		Given User login with username "developer" and password "23"
		When User get login message "Welcome to Tele Kita"
		And User click ok to the validate message
		And User move to table_Data
		And User move to table Edit Data
		And User select the latest data
		And User update or edit the data
		And User confirm or click update button
		Then User see data changed successfully for latest data

	Scenario: InValid Edit
		Given User login with username "developer" and password "23"
		When User get login message "Welcome to Tele Kita"
		And User click ok to the validate message
		And User move to table_Data
		And User move to table Edit Data
		And User select the earliest data
		And User update or edit the data
		And User not confirm or click close button
		Then User see data not changed for earliest data
		
	Scenario: InValid Edit
		Given User login with username "developer" and password "23"
		When User get login message "Welcome to Tele Kita"
		And User click ok to the validate message
		And User move to table_Data
		And User move to table Edit Data
		And User select the latest data
		And User update or edit the data
		And User not confirm or click close button
		Then User see data not changed for latest data