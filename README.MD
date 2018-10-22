## Finance Active Interview

### Used Patterns

To implement the computation fees I've used a strategy pattern with combination of template pattern:
- Abstract strategy holds most of the computation pattern.
- Concrete classes provide implementation getVariation method that get the rate to apply to the fees.

Even if the computation algorithm is not so different from one strategy to another, it is a good candidate for using
strategy pattern. The solution is this way open to futur modification of the algorithm.

### General principals

I used a maven multi-modules project to split into app, api and impl. This way api is differenciated from impl. An 
elegant way of setting the implementation will be to use an IOC framework like spring code or guice.

Test are implemented once the api is implemented and then used to test and debug impl. Tests in this projects needs to 
be improved.

The integration of a logging framework will be imporant for production solution.

 
