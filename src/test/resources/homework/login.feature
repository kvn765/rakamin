Feature: transaction

  @Positive
  Scenario: sukses login
    Given ada di halaman login saucedemo
    When masukan username valid
    And masukan password valid
    And klik tombol login
    Then diarahkan ke homepage
    And stop sesi

  @Negative
  Scenario: gagal login
    Given ada di halaman login saucedemo
    When masukan username valid
    And masukan password invalid
    And klik tombol login
    Then tampilkan error message
    And stop sesi

  @Positive
  Scenario: tambahkan produk ke dalam cart
    Given ada di halaman login saucedemo
    When masukan username valid
    And masukan password valid
    And klik tombol login
    Then diarahkan ke homepage
    And ada di halaman inventory
    When klik tombol atc
    Then tombol atc berubah jadi remove
    And counter di cart jadi satu
    And stop sesi

  @Positive
  Scenario: remove produk dari katalog
    Given ada di halaman login saucedemo
    When masukan username valid
    And masukan password valid
    And klik tombol login
    Then diarahkan ke homepage
    And ada di halaman inventory
    And klik tombol atc
    And tombol atc berubah jadi remove
    And counter di cart jadi satu
    When klik tombol remove
    Then counter di cart jadi nol
    And stop sesi

    @Positive
    Scenario: logout
      Given ada di halaman login saucedemo
      When masukan username valid
      And masukan password valid
      And klik tombol login
      Then diarahkan ke homepage
      When klik burger
      And klik logout
      Then ada di halaman login saucedemo