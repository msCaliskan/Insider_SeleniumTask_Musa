Feature: Insider Selenium Task Study

  @taskQA
  Scenario: Insider QA Task

    Given The user is on the home page and checks Insider page is opened or not
    And The user navigates to "More" tab "Careers" module
    When Checks on the Careers Page following blocks are opened or not
      | Our story               |
      | Find your calling       |
      | Our Locations           |
      | Life at Insider         |
      | Why Become One of Us    |
      | Create your life’s work |
    When Scroll to "Find your dream job" button and click
    Then Apply filter jobs by Location "Istanbul, Turkey" and department "Quality Assurance"
    And Check presence of jobs list
    Then Check all jobs positions contains "Quality Assurance" or "QA"
    And Check all departments contains "Quality Assurance"
    And Check all locations contains "Istanbul, Turkey"
    When Select one of the positions listed check correct position page is opened
    Then Check presence of job description, requirements and "Apply for this job" button
    And Click "Apply for this job" button and check that this action redirects us to Lever Application form page

