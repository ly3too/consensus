package cn.ly3too.consensus.base

import Log._
import StateMachine.Command

/**
 * the basic interface for consensus log store
 */
trait Log {
    /**
     * append a new entry to log store
     * @param entry log entry to be appended
     * @return index of current appended log entry
     */
    def append(entry: LogEntry): Index

    /**
     * get an entry at index
     * @param index index at which to get the entry. Negative index indicate last entry
     * @return log entry if exists
     */
    def getEntry(index: Index): Option[LogEntry]

    /**
     * get the last log index
     * @return last appended index. -1 means log store are empty
     */
    def getLastIndex: Index

    /**
     * get the size of the log store
     * @return
     */
    def size(): Size

    /**
     * delete old entries, used for snapshot
     * @param index index before which to delete
     */
    def discardBefore(index: Index): Unit
}

object Log {
    type Index = Long
    type Size = Long
    trait LogEntry extends Serializable {
    }
}