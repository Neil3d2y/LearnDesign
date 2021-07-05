# System Design Interview Tips

### Tips for Interview
1. It's ok to not know something.
2. It's all about signals.
    - no red flags (Cassandar, Redis for bank transaction)
    - (Cassandar is last write win (timestamp different on different machines can cause overwrite))
    - Use database to store multi-media data
3. It's about wisdoms
    - single point of failure
    - LINUX: keep it stupid simple
    - everthing looks like a nail if you are holding a hammer
    


## Truth, Knowledge and Lies
#### Single Node
In a single computer system, the result is deterministic. If there is a hardware problem, there consequence
is usually a total system failure("blue screen of death")

> B-day paradox: 99.9% probability when group is 70 people, 23 people with 50%

###Commercial DC - Clos topology
what makes Google, the exact opposite design idea of building a super computer.
With this design, followings are the facts:
- Network is unreliable
- Clock is unreliable ( Network Time Protocol (NTP) )
#### Type of clock
1. time-of-day clock
```
clock_gettime(CLOCK_REALTIME)
System.currentTimeMillis()
```
Both sync with NTP, highly unreliable

2. Monotonic Clock
```
clock_gettime(CLOCK_MONOTONIC)
System.nanoTime()
```

#### Process Pause
1. ***"stop-the-world" GC***
When Garbage Collection start to work, stop everything
2. context-switches
  > thrashing: OS terminology, thrashing is a state in which the CPU performs productive work less, and `swapping` more. 
  > The CPU is busy in swapping pages so much that it cannot respond to users' programs and interrupts as much as required.
  > Occurs when there are too many pages in memory, and each page refers to another page.

3. synchronous disk access, a thread may be paused waitting for a slow disk I/O operation. Case: Java Class Loader(laze load) load first time
4. Real time OS:every library call has a worst time guaranteed

Redis -> Redlock: fault-tolerant distributed locks: <span style="color:red">fundamentally wrong</span>, because no fencing token

##### Real case in HBase: 
![HBase unsafe lock Case](images/unsafe-lock.png)

Solution: fencing token, Zookeeper incrasing transaction ID, if transaction ID backward, block it.


### Truths
1. Node int the network cannot know anything for sure
2. A node can only find out what state another node is by exchanging messages with it. If a remote node doesn't respond, never knows
3. Truth is defined by **Majority**. When disagree, need consensus.


### Lies
Byzantine failures. unreliable node / network


## Different modles in Distributed system
1. Synchronous model (irrealistic)
2. Partially synchronous model
3. Asynchronous model
4. Crash-stop faults
5. Crash-recovery faults
6. Byzantine faults


### Ref
- [Sys Design Tips](https://docs.google.com/presentation/d/1U1ODftWc2kSu_AZ8ZrvCifIOTfKjGNCgcj0fbj8DQWg)
- [Truth, Knowledge and Lies](https://docs.google.com/presentation/d/1hHFVhPWCdgrIYlc40AosVb_BrJ_EP3fl7M3SQsbwBjU)