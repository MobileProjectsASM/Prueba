package com.example.prueba.data.source.hardware

class ConnectionImpl: Connections {
    override fun isThereNetworkConnection(): Boolean {
        return false
    }
}