SE320 Homework 5: GUI Testing
Fall 2017

    Assignment out: 12/01/2017
    Assignment due: 12/08/2017 by 11:59pm
    Late Policy: None, due to the end of the term

Overview

The goal for this assignment is to give you just a taste of GUI testing.

You have been given a gradle project. Inside the web/ subdirectory, there is a single file index.html. If you open it in your web browser, you'll see that it is a very (very) simple TODO list.

Your job is to test the GUI functionality, including:

    Can you add TODOs?
    Can you remove TODOs?
    If you remove one TODO, are the others still there?
    etc.

There are three parts to this assignment:

    Write an event flow graph that assumes there are up to two TODO items in the list.
        Technically this UI is outside the scope of an event flow graph, since new elements (in particular, buttons) are created dynamically. This is a simplification.
    Write enough tests to achieve event coverage on your event flow graph
        Most of the tests will indeed be very similar, and will need to start by setting up two-element TODO lists.
        There are many things you could consider checking in your tests. To keep things simple, your tests should only check the following:
            If you add a TODO, that TODO should now be present
            If you remove a TODO, that TODO is now gone, and any other TODOs still exist (regardless of location)
    Briefly explain the trade-offs involved in stopping at event coverage for this program, rather than pursuing event interaction coverage or length-n event sequence coverage. What kinds of tests is this simpler coverage criteria not forcing you to write? What are the advantages of not writing them (think about how many tests you'd need for the stronger criteria...).

Skeleton Code and Dependencies

You've been given a test class with a single working test. In order to make it work on your system, you'll need to do the following:

    Modify the uiPath string in that class to give the file URL to web/index.html on your system. This is "file://" followed by the full system path to that file wherever you've unpacked the zip file. The easiest way to get this is to open web/index.html in your favorite browser, and copy what the browser puts in your address bar over as the new value of uiPath.
    Install GeckoDriver (https://github.com/mozilla/geckodriver), the program Selenium uses to control an instance of the Firefox web browser.
        For all platforms, you can download and install from the release page
        On Mac, you can use homebrew to install geckodriver, but it will take a long time (it compiles the Rust compiler if you do this)
    Make sure geckodriver is in your system path. There are directions for this in the Selenium section of the GeckoDriver instructions. (As you read those instructions, don't worry about the Selenium version business; the gradle project uses an appropriate version.)

Once all three of the steps above are done, the existing test in the project should pass.

We strongly encourage you to try this much on the early side, even if you don't intend to do the bulk of the work until later in the week. This will give us more time to help with any installation issues that may come up.
Submission

Please submit

    a zip or tarball including the whole gradle project
    an appropriate picture format (PDF, BMP, JPG, PNG) for your event flow graph
    an appropriate text format (TXT, RTF, PDF) for your written explanation.

Grading

    40% Event flow graph
    40% Tests that achieve event coverage
    20% Discussion of trade-offs

This assignment is itself worth 10% of your term grade.