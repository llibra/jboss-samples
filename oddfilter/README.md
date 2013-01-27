テストした手順：

    % cat test.xml
    <numbers>
      <number>0</number>
      <number>1</number>
      <number>2</number>
      <number>3</number>
      <number>4</number>
      <number>5</number>
      <number>6</number>
      <number>7</number>
      <number>8</number>
      <number>9</number>
    </numbers>
    % curl -X POST -H "Content-Type: application/xml" -d "@test.xml" http://localhost:8080/oddfilter/rest/oddfilter/filter
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?><numbers><number>1</number><number>3</number><number>5</number><number>7</number><number>9</number></numbers>
