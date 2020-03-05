## General notes

* Consider adopting codestyle
    * I recommend automating it with [spotless][spotless] with Google Java Format
* Logging is complicated topic in java.
    * Use slf4j as a logging facade
* Working with buffered readers/writers does not look nice to me
    * But I don't have any specific suggestions at the moment
    
[spotless]: https://github.com/diffplug/spotless