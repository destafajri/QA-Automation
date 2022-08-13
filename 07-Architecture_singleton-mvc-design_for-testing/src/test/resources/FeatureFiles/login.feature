Feature: User Supervisor

	Scenario: Valid Login
		Given User Admin Mengakses URL sqa peluang kerjaku
		When User Admin mengisi username
		And User Admin mengisi password
		And User Admin menekan tombol submit
		Then User Admin mendapatkan notifikasi
		