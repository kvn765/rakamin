Feature: login saucedemo

  Scenario: sukses login
    Given ada di halaman login saucedemo
    When masukan username valid
    And masukan password valid
    And klik tombol login
    Then diarahkan ke homepage

  Scenario: gagal login
    Given ada di halaman login saucedemo
    When masukan username valid
    And masukan password invalid
    And klik tombol login
    Then tampilkan error message