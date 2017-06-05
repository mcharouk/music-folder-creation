Feature: create folders which names are based on the mp3 tags given in parameter

Scenario: folder name definition

Given some file with a tag artist as "Louis Armstrong"
And tag genre as "Jazz"
When i create a file
Then relative path folder should be "Jazz/Louis Armstrong"
 