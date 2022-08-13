Feature: Upload Data Test

	Scenario: Valid Upload
#		Given User Admin Mengakses URL sqa peluang kerjaku
		When User admin menekan tombol ok pada pesan validasi
		And User admin berpindah ke tabel data
		And User damin berpindah ke tabel upload Data
		And UserSpv import excel file from directory "C:\\Users\\ASUS\\Downloads\\customers.xlsx"
		And UserSpv click Upload file
		Then UserSpv get new data import on the page or website
		And UserSpv save the new file
		And UserSpv get measurement statement Yakin Menimpan ?
		And UserSpv click SIMPAN button
		Then UserSpv get validation message "Data Berhasil Simpan"
		
	Scenario: InValid Upload
#		Given User Admin Mengakses URL sqa peluang kerjaku
		When User admin menekan tombol ok pada pesan validasi
		And UserSpv move to table Data
		And UserSpv move to table Upload Data
		And UserSpv import excel file from directory ""
		And UserSpv click Upload file
		Then UserSpv get message "File tidak dapat dibaca/ jumlah data 0"
		And UserSpv close the validation message
		And UserSpv save the new file
		And UserSpv get measurement statement Yakin Menimpan ?
		And UserSpv click SIMPAN button
		Then UserSpv get validation message "Data Kosong"