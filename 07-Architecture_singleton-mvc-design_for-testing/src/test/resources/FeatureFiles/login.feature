Feature: User Supervisor

	Scenario Outline: Invalid Login
		Given User Admin Mengakses URL sqa peluang kerjaku
		When User Admin mengisi username <username>
		And User Admin mengisi password <password>
		And User Admin menekan tombol submit
		Then User Admin mendapatkan allert
	Examples:
		|	username		|	password	|
		| "developer"	| "2"				|
		| "deVELOPEER"|	"23"			|
		| ""					| ""				|
		
	Scenario: Valid Login
		Given User Admin Mengakses URL sqa peluang kerjaku
		When User Admin mengisi username
		And User Admin mengisi password
		And User Admin menekan tombol submit
		Then User Admin mendapatkan notifikasi		

	
	
	