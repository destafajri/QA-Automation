Feature: Upload Data Test

	Scenario: Valid Upload
		Given User on the login page
		When User login with valid username "developer" and password "23"
		And User get login validate "Welcome to Tele Kita"
		And User click ok to the validate message
		And User move to table Data
		And User move to table "Upload Data"
		And User import excel file from directory "C:\\Users\\ASUS\\Downloads\\customers.xlsx"
		And User click "Upload" file
		And User save the new file
		Then User get measurement statement Yakin Menimpan ?
		And User click "SIMPAN" button
		Then User get validation message "Data Berhasil Simpan"
		
	Scenario: InValid Upload
		Given User on the login page
		When User login with valid username "developer" and password "23"
		And User get login validate "Welcome to Tele Kita"
		And User click ok to the validate message
		And User move to table Data
		And User move to table "Upload Data"
		And User import excel file from directory ""
		And User click "Upload" file
		Then User get message "File tidak dapat dibaca/ jumlah data 0"
		And User close the validation message
		And User save the new file
		Then User get measurement statement Yakin Menimpan ?
		And User click "SIMPAN" button
		Then User get validation message "Data Kosong"