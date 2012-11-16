delimited-profiler
==================

Library and Executable to auto-analyze delimited text files

## Purpose

Create an automated "profiler" for delimited text files.

* Auto-detect EOL [ \n \r\n \r ]
* Auto-detect delimiter [ | \t , ].  Permit user specification
* If CSV (comma delimited), attempt "intelligent" handling of Excel variants (quoted text fields)
* Start counting raw field values
* "demote" fields if too many distinct values
* Attempt to manage memory.  In the past, I have worked with text files up to 1GB in size.

## Goals

* start my own project I have mentally chewed on for years
* learn and attempt "good habits"
* apply TDD
* apply functional programming concepts
* serve own generic needs
* provide a useful tool/library for others
