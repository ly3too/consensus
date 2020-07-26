package cn.ly3too.consensus.raft

import Raft._

abstract class State(raft: Raft) {
    /**
     * start to current state
     */
    def start()

    /**
     * end of current state
     */
    def stop()

    /**
     * onAppendEntries rpc backend
     * @param args args from leader
     * @return result to be send back
     */
    def onAppendEntries(args: AppendEntriesArgs): AppendEntriesRes

    /**
     * requestVote rpc backend
     * @param args rpc args
     * @return res to be send back
     */
    def onRequestVote(args: RequestVoteArgs): RequestVoteRes
}
