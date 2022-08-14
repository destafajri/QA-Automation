Feature: Cek Product

Scenario: Cek Name
	Given User access the URL
	When User search a product "iphone"
	And User send enter query
	Then User see all product "iphone"