DESCRIPTION = "High level compatibility layer for multiple asynchronous event loop implementations"
HOMEPAGE = "https://pypi.org/project/anyio/"
LICENSE = "BSD"

# Bypass license checking for pre-built wheels - file not in wheel at expected path
NO_GENERIC_LICENSE["BSD"] = "LICENSE.txt"

WHL_FILE = "cryptography-40.0.1-cp38-cp38-linux_armv7l.whl"
GIT_NAME = "AhmedElghaly"

SRC_URI = "https://github.com/Network-Engineering-PDU/cryptography-40.0.1/raw/main/${WHL_FILE};unpack=0"

SRC_URI[sha256sum] = "0514c1ea7730ae9fbaf35f2ec57c7e69d6d500e139faa6390e16821d08767688"

BBCLASSEXTEND = "native nativesdk"
inherit python3-dir

