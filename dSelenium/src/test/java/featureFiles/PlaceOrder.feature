Feature: place a order

  Scenario: place a valid order
    Given setup the driver and open the site
    When our site is on home page
    Then add some items to cart
    Then click on cart button and proceed to checkout
    Then enter promoCode and click apply and verify
    Then place order
    Then select country and click agree
    Then verify order is placed

  Scenario: place a valid order without click agree
    Given setup the driver and open the site
    When our site is on home page
    Then add some items to cart
    Then click on cart button and proceed to checkout
    Then enter promoCode and click apply and verify
    Then place order
    Then select country
    Then verify order is not placed