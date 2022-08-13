Feature: Upload Data Test

	Scenario: Valid Upload
#		Given User Admin Mengakses URL sqa peluang kerjaku
		When User admin menekan tombol ok pada pesan validasi
		And User admin berpindah ke tabel data
		And User admin berpindah ke tabel upload Data
		And User admin melakukan import excel dari directory
		And User admin menekan tombol upload
		Then User melihat jumlah data pada website sama dengan jumlah data file excel
		And User admin melakukan penyimpanan data
		And User mendapatkan pesan validasi Yakin Menimpan ?
		And User admin melakukan penyimpanan
		Then User admin mendapatkan pesan validasi "Data Berhasil Simpan"
		
	Scenario: InValid Upload
#		Given User Admin Mengakses URL sqa peluang kerjaku
		When User admin menekan tombol ok pada pesan validasi
		And User admin berpindah ke tabel data
		And User admin berpindah ke tabel upload Data
		And User admin melakukan tidak melakukan import excel dari directory ""
		And User admin menekan tombol upload
		Then User admin mendapatkan alert "File tidak dapat dibaca/ jumlah data 0"
		And User admin melakukan penyimpanan data
		And User mendapatkan pesan validasi Yakin Menimpan ?
		And User admin melakukan penyimpanan
		Then User admin mendapatkan pesan validasi "Data Kosong"