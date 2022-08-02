Feature: login Test

	Scenario: Valid Login
		Given User on the login page
		When User fill the username "developer"
		And User fill the password "23"
		And User click the login button
		Then User get login validate "Welcome to Tele Kita"
	
	Scenario: InValid Login
		Given User on the login page
		When User fill the username "develop"
		And User fill the password "23"
		And User click the login button
		Then User get alert or notification "Username atau password tidak ditemukan atau akun anda tidak aktif"