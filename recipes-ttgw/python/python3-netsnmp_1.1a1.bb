SUMMARY = "Python3 port of the official Net-SNMP Python bindings."
HOMEPAGE = "https://github.com/bluecmd/python3-netsnmp"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=81616fb0d5600f45562c5edf5a8e8cf6"

SRCBRANCH = "master"
SRCREV = "28106277f18acc4f66b4621408652217204d305b"
SRC_URI = "git://github.com/bluecmd/python3-netsnmp.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

DEPENDS += " net-snmp"

#PYPI_PACKAGE = "python3-netsnmp"

#inherit pypi setuptools3
inherit setuptools3

RDEPENDS:${PN} += "\
"

BBCLASSEXTEND = "native nativesdk"
