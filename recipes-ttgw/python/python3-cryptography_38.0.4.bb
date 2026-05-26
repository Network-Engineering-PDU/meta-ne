DESCRIPTION = "Cryptographic recipes and primitives for Python"
HOMEPAGE = "https://pypi.org/project/cryptography/"
LICENSE = "Apache-2.0 or BSD"
LIC_FILES_CHKSUM = "file://site-packages/cryptography-38.0.4.dist-info/LICENSE;md5=bf405a8056a6647e7d077b0e7bc36aba"

WHL_FILE = "cryptography-38.0.4-cp38-cp38-linux_armv7l.whl"

SRC_URI = "https://files.pythonhosted.org/packages/90/79/cdcec1e965a5e66348a96af68b8f48c9b3e6b97308ab6c9e07f6a46e3831/cryptography-38.0.4-cp38-cp38-linux_armv7l.whl;unpack=0"

SRC_URI[sha256sum] = "5f61c9fbecbf73544fec755e46dc2e2c1b5f1e913f4c0616dfb9e1e07c9ae53f"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-six \
"
