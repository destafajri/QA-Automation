Feature: Search Vacancy Test

	Scenario: search job vacancy
		Given User on the Browser
		When User type url "https://kerja.kitalulus.com/id"
		And User send the url to the browser
		Then User get title validate "Info Lowongan Kerja Terbaru 2022 - Kitalulus"