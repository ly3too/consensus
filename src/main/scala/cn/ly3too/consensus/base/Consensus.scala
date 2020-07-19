package cn.ly3too.consensus.base

trait Consensus {
    val log: Log // non-volatile log system
    val rpc: Rpc // rpc backend
    val stateMachine: StateMachine // statemachine
    val store: Store // non-volatile store

    /**
     * start running of Consensus system
     */
    def start()

    /**
     * stop running
     */
    def stop()
}
