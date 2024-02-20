# Chisel Sequential Logic Repository

This assignment has 3 modules for you to complete.

- SimpleCounter4
    - This module should count up from 0 on every rising clock edge up to the input countMax value(set to be 4 bits). It should output the currentCount that can be looked at every clock tick. When the countMax value is reached, the currentCount should be set to 0, and counting should resume. Below is a diagram of how this can be done with a Mux and a Register
    
        <img src=".\counter.png" alt="Alt text" style="width: 80%; height: 80%;">

- AnyCounter 
    - This module should only set its output flag to true when the input number of clock ticks have passed, and then set it back to false. This module also needs the input of width, to set the width of your register (a larger number of input ticks would require a larger register to hold them)


- ShotClock (24 seconds)
    - This module has a "shot" input that should reset your shot clock back to 24, and an output of timeLeft on the shotclock which should decrement, along with the output boolean if there has been a shot clock violation (the shot clock hit 0)
    - You can use your AnyCounter here, and for testing I recommend that you set your tick value around 10 so that your tests run quickly and so that you can see it on the waveform.


There is also a demo package that has the demos from class on how to use registers and the non functional SRLatch(it creates a combinational loop), feel free to run it and take a look at the errors

    

**Getting the Repo:**
```bash
$ https://github.com/ebiernacki/chisel-sequential-logic.git 
```

**Testing the Examples**
- To test the SimpleCounter4 Module:
    ```bash
    sbt
    testOnly Timing.SimpleCounter4Test
    ```
- replace ```SimpleCounter4Test``` with the name of the test you want to run



## External Setup Guides and Running the Projects

- [Java, Sbt and Chisel Guide](https://docs.google.com/document/d/13pX-4cFuGuj_i7VRhmksyf7YL6-qXiF8-O9J9m_yVfI/edit?usp=sharing)
- [GTKWave Guide](https://docs.google.com/document/d/1-muYy8XSGP4EbMIbLuwTEscIj1UC-u8HU5glcBpIFUo/edit?usp=sharing)
- [Vivado Guide](https://docs.google.com/document/d/1O-y1rnS1V_Bjyc2GwYd9C6Gq1IsqVcxacy2lTD6tHME/edit?usp=sharing)





