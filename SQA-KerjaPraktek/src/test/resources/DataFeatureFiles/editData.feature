Feature: Edit Data Test

	Scenario: Valid Edit
		Given User login with username "developer" and password "23"
		When User get login msg "Welcome to Tele Kita"
		And User click ok to the validate msg
		And User move to table_Data
		And User move to table Edit Data
		And User select the earliest data
		And User update or edit the data
		And User confirm or click update button
		Then User see data changed successfully
		
		
	Scenario: Valid Edit
		Given User login with username "developer" and password "23"
		When User get login msg "Welcome to Tele Kita"
		And User click ok to the validate msg
		And User move to table_Data
		And User move to table Edit Data
		And User select the latest data
		And User update or edit the data
		And User confirm or click update button
		Then User see data changed successfully

	Scenario: InValid Edit
		Given User login with username "developer" and password "23"
		When User get login msg "Welcome to Tele Kita"
		And User click ok to the validate msg
		And User move to table_Data
		And User move to table Edit Data
		And User select the earliest data
		And User update or edit the data
		And User not confirm or click close button
		Then User see data not changed
		
	Scenario: InValid Edit
		Given User login with username "developer" and password "23"
		When User get login msg "Welcome to Tele Kita"
		And User click ok to the validate msg
		And User move to table_Data
		And User move to table Edit Data
		And User select the latest data
		And User update or edit the data
		And User not confirm or click close button
		Then User see data not changed