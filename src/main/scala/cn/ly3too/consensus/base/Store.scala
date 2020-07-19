package cn.ly3too.consensus.base

/**
 * a persistent store
 */
trait Store {
    /**
     * save persistent value
     * @param what what to save
     * @tparam T type of saved info
     * @return
     */
    def save[T](what: T): AnyRef

    /**
     * get saved info
     * @tparam T type of saved info
     * @return
     */
    def get[T]: T

    /**
     * save snapshot
     * @param snapShot to be saved
     */
    def saveSnapShoot(snapShot: SnapShot)

    /**
     * get last saved snapshoot
     * @return saved snapshot if any
     */
    def getLastSnapShoot: Option[SnapShot]
}
