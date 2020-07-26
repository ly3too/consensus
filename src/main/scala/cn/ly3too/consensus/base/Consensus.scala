package cn.ly3too.consensus.base

abstract class Consensus extends RpcService {
    def log: Log // non-volatile log system
    def rpc: RpcClient // rpc client to communicate with other member
    def stateMachine: StateMachine // statemachine, to which commands will be applied
    def store: Store // non-volatile store

    /**
     * initialize by config
     * @param config config
     */
    def configure(config: Config)

    /**
     * start running of Consensus system
     */
    def start()

    /**
     * stop running
     */
    def stop()
}
