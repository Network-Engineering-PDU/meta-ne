DESCRIPTION = "InfluxDB 2.0 Python client library"
HOMEPAGE = "https://github.com/influxdata/influxdb-client-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a2d82955bf3facdf04cb882655e840e"

SRC_URI[sha256sum] = "295874861c173f9101960bba332429bb77ed4dcd8cdf5cee9922eb00e4f6bc09"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"

DEPENDS += "${PYTHON_PN}-setuptools-native ${PYTHON_PN}-cython-native"
RDEPENDS:${PN} = ""
