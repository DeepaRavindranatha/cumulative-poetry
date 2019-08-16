# Cumulative Poetry

We are building a product that will be used in poetry classes. We target a poetry of a form called as cumulative poetry. The functionality is broken down into releases and its recommended that you approach the problem incrementally. 

## Release 1 Expectations

**Business needs**

Cumulative poetry shows itself little by little. It’s much like unfolding a tale. The one taught in the class goes like - 

+ Day 1 
```
This is the house that Jack built.
```

+ Day 2
```
This is the malt that lay in
    the house that Jack built.
```

+ Day 3 
```
This is the rat that ate
    the malt that lay in
    the house that Jack built.
```

And so on, as you see the tale is unfolded little by little every day. The whole tale is unfolded on,

+ Day 12
```
This is the horse and the hound and the horn that belonged to
    the farmer sowing his corn that kept
    the rooster that crowed in the morn that woke
    the priest all shaven and shorn that married
    the man all tattered and torn that kissed
    the maiden all forlorn that milked 
    that cow with the crumpled horn that tossed
    the dog that worried 
    the cat that killed
    the rat that ate
    the malth that lay in 
    the house that Jack built.
```
___

**Technical needs**

1. You are expected to commit the source code in a private github repository shared with your trainers.
2. There should be a documented way of generating a jar that supports above mentioned functionality, with the following behaviour:

Flags supported 
- `--reveal-for-day for_which_day` : Reveals the tale up till that day
- `--recite` : Recites the whole tale with a day wise breakage

Example usage: 

`$ java -jar poetry-class.jar --reveal-for-day 1`
```
This is the house that Jack built.
```

`$ java -jar poetry-class.jar --reveal-for-day 2`
```
This is the malt that lay in
    the house that Jack built.
```

`$ java -jar poetry-class.jar --recite`
```
Day 1 - 
This is the house that Jack built.

Day 2 - 
This is the malt that lay in
    the house that Jack built.

... // There will be a tale for everyday
...

Day 12 - 
This is the horse and the hound and the horn that belonged to
    the farmer sowing his corn that kept
    the rooster that crowed in the morn that woke
    the priest all shaven and shorn that married
    the man all tattered and torn that kissed
    the maiden all forlorn that milked 
    that cow with the crumpled horn that tossed
    the dog that worried 
    the cat that killed
    the rat that ate
    the malth that lay in 
    the house that Jack built.

```

3. It is expected that all code is unit tested. If you don't know about unit tests, don't worry - here is a friendly [blog](https://martinfowler.com/bliki/UnitTest.html) by Martin Fowler talking about unit testing. And you can take a look at  [junit's official guide](https://junit.org/junit5/docs/current/user-guide/) to efficiently write tests with same.

4. Its expected you write all code using git as your version control system pushed to a private remote repository like Bitbucket and you share access with your mentors.

5. Please use a convention for your git messages, like the one mentioned [here](https://chris.beams.io/posts/git-commit/). Also, try to keep your commits small with one logical change in each commit.

6. We already have included `gradle` as the build tool. You can learn about it from [official documentation](https://gradle.org/guides/#getting-started). However be careful with the time you spend on it, as its quite exhaustive. It might be better to connect with people in your office who already worked with or know about gradle. Anyhow, `./gradlew test` should get you started for running tests. 

## Expectation from release 2

The poetry class wants each line to echo twice, if the flag is specified. Else retain the default behaviors. The purpose is that the poetry starts reading more like a song.

**Technical expecations**

1. Support the new flags as shown below

Flags supported 
- `--reveal-for-day for_which_day [--echo]` : Reveals the tale up till that day, with an optional echo
- `--recite [--echo]` : Recites the whole tale with a day with an optional echo

Example usage: 

`$ java -jar poetry-class.jar --reveal-for-day 1`
```
This is the house that Jack built.
```

`$ java -jar poetry-class.jar --echo --reveal-for-day 1`
```
This is the house that Jack built
    the house that Jack built.
```

`$ java -jar poetry-class.jar --echo --reveal-for-day 2`
```
This is the malth that lay in
    the malth that lay in
    the house that Jack built
    the house that Jack built.
```

`$ java -jar poetry-class.jar --echo --recite`
```
Day 1 - 
This is the house that Jack built
    the house that Jack built.

Day 2 - 
This is the malth that lay in
    the malth that lay in
    the house that Jack built
    the house that Jack built.

... // There will be a tale for everyday
...

Day 12 - 
This is the horse and the hound and the horn that belonged to
    the horse and the hound and the horn that belonged to
    the farmer sowing his corn that kept
    the farmer sowing his corn that kept
    the rooster that crowed in the morn that woke
    the rooster that crowed in the morn that woke
    the priest all shaven and shorn that married
    the priest all shaven and shorn that married
    the man all tattered and torn that kissed
    the man all tattered and torn that kissed
    the maiden all forlorn that milked 
    the maiden all forlorn that milked 
    that cow with the crumpled horn that tossed
    that cow with the crumpled horn that tossed
    the dog that worried 
    the dog that worried 
    the cat that killed
    the cat that killed
    the rat that ate
    the rat that ate
    the malth that lay in 
    the malth that lay in 
    the house that Jack built.
    the house that Jack built.
```
2. As mentioned previously, all code is unit tested. Maintained in source control with small commits.

3. Try to ensure that your classes are bite sized and have a single responsibility allocated to them. A practise of [Object Calisthenics](https://www.cs.helsinki.fi/u/luontola/tdd-2009/ext/ObjectCalisthenics.pdf) can help you achieve that.

## Expectation from release 3

The poetry class want to experiement with randomly generated poetry. The tale must always end with **the house that Jack built.**

**Technical expecations**

1. Support the new flags as shown below

Flags supported 
- `--reveal-for-day for_which_day [--random] [--seed seed_value] [--echo]` : Reveals the tale up till that day, optionally in a random order with an optional echo or both, as specified
- `--recite [--random] [--seed seed_value] [--echo]` : Recites the whole tale with a day wise breakage, optionally in a random order with an optional echo or both, as specified

Program run with the same seed values should generate same poetry. If you don't know what's a seed value, take a look at this [wiki page](https://en.wikipedia.org/wiki/Random_seed) or this [quora answer](https://www.quora.com/What-is-seed-in-random-number-generation). In our case, seed values shall help us test randomness in our code.

Example usage: (*Note seed values are just examples, your results might differ*)

`$ java -jar poetry-class.jar --reveal-for-day 2`
```
This is the malt that lay in
    the house that Jack built.
```

`$ java -jar poetry-class.jar --reveal-for-day 2 --random`
```
Seed used - 123 
This is the man all tattered and torn that kissed
    the house that Jack built.
```

`$ java -jar poetry-class.jar --reveal-for-day 2 --random --seed 10`
```
Seed used - 10 
This is the dog that worried 
    the house that Jack built.
```

As mentioned, using the seed agai, produces the same result:

`$ java -jar poetry-class.jar --reveal-for-day 2 --random --seed 123`
```
Seed used - 123 
This is the the man all tattered and torn that kissed
    the house that Jack built.
```

Also, recitation follows similar pattern:

`$ java -jar poetry-class.jar --recite --random --seed 123`
```
Seed used - 123
Day 1 - 
This is the house that Jack built.

Day 2 - 
This is the man all tattered and torn that kissed
    the house that Jack built.

... // There will be a tale for everyday
...

Day 12 - 
This is 
    the farmer sowing his corn that kept
    the horse and the hound and the horn that belonged to
    the priest all shaven and shorn that married
    the malth that lay in
    the maiden all forlorn that milked 
    that cow with the crumpled horn that tossed
    the rooster that crowed in the morn that woke
    the dog that worried 
    the rat that ate
    the cat that killed
    the man all tattered and torn that kissed 
    the house that Jack built.
```

Both echo and random - 

`$ java -jar poetry-class.jar --echo --reveal-for-day 2 --random --seed 10`
```
Seed used - 10
This is the dog that worried 
    the dog that worried
    the house that Jack built
    the house that Jack built.
```

`$ java -jar poetry-class.jar --echo --recite --random --seed 123`
```
Seed used - 123
Day 1 - 
This is the house that Jack built
    the house that Jack built.

Day 2 - 
This is the man all tattered and torn that kissed
    the man all tattered and torn that kissed
    the house that Jack built
    the house that Jack built.

... // There will be a tale for everyday
...

Day 12 - 
This is 
    the farmer sowing his corn that kept
    the farmer sowing his corn that kept
    the horse and the hound and the horn that belonged to
    the horse and the hound and the horn that belonged to
    the priest all shaven and shorn that married
    the priest all shaven and shorn that married
    the malth that lay in
    the malth that lay in
    the maiden all forlorn that milked 
    the maiden all forlorn that milked 
    that cow with the crumpled horn that tossed
    that cow with the crumpled horn that tossed
    the rooster that crowed in the morn that woke
    the rooster that crowed in the morn that woke
    the dog that worried 
    the dog that worried 
    the rat that ate
    the rat that ate
    the cat that killed
    the cat that killed
    the man all tattered and torn that kissed 
    the man all tattered and torn that kissed 
    the house that Jack built
    the house that Jack built.
```

2. As mentioned previously, all code is unit tested. Maintained in source control with small commits.

3. Avoid having duplications in code or in test. Avoid if conditions as much as possible (If they exist outside of your Parser's or [Factories](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm), question why do they exist). 
