package cn.ly3too.consensus.raft

import cn.ly3too.consensus.base.StateMachine.Command
import cn.ly3too.consensus.base._

class Raft(logParam: Log, rpcParam: RpcClient, stateMachineParam: StateMachine, storeParam: Store) extends Consensus {
    override def log: Log = logParam
    override def rpc: RpcClient = rpcParam
    override def stateMachine: StateMachine = stateMachineParam
    override def store: Store = storeParam

    /**
     * initialize by config
     *
     * @param config config
     */
    override def configure(config: Config): Unit = {
        // todo
    }

    /**
     * start running of Consensus system
     */
    override def start(): Unit = {
        // todo
    }

    /**
     * stop running
     */
    override def stop(): Unit = {
        // todo
    }

    /**
     *
     * @param func rpc service provided by rpc server
     * @return
     */
    override def onRpc(func: Rpc.RpcFunction): AnyRef = {
        // todo
        Unit
    }
}

object Raft {
    type Term = Long // raft term
    type PeerId = String // raft server id
    type LogIndex = Long
    type CommitIndex = LogIndex

    case class LogEntry (term: Term, index: LogIndex, command: Command) extends Log.LogEntry

    /**
     * appendEntries rpc arguments
     *
     * @param term leader's current term
     * @param leaderId     leader's id
     * @param prevLogIndex index of log entry immediately preceding
     *                     new ones
     * @param prevTerm term of prevLogIndex entry
     * @param entries log entries to store, empty for heartbeat
     * @param leaderCommitIndex leader's commit index
     */
    case class AppendEntriesArgs(term: Term, leaderId: PeerId, prevLogIndex: LogIndex, prevTerm: Term,
                                 entries: List[LogEntry], leaderCommitIndex: LogIndex)

    /**
     * appendEntries rpc return type
     * @param term follower's current term, for leader to update itself
     * @param success true if follower contain entry matching prevLogIndex and prevLogTerm
     */
    case class AppendEntriesRes(term: Term, success: Boolean)

    /**
     * request vote rpc args
     * @param term current term of candidate
     * @param candidateID id
     * @param lastLogIndex index of candidate's last log entry
     * @param lastLogTerm term of candidate's last log term
     */
    case class RequestVoteArgs(term: Term, candidateID: PeerId, lastLogIndex: LogIndex, lastLogTerm: Term)

    /**
     * request vote rpc's return type
     * @param term current term, for candidate to update itself
     * @param voteGrated true if candidate vote grated
     */
    case class RequestVoteRes(term: Term, voteGrated: Boolean)
}
