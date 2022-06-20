#!/bin/bash

INSTALL_DIR="${HOME}/.local/bin"
REVIEWDOG_PATH="${INSTALL_DIR}/reviewdog"
CHECKSTYLE_PATH="${INSTALL_DIR}/checkstyle.jar"
REVIEWDOG_VERSION=v0.10.0

echo "Checking if installdir is present"
if [[ ! -d "${INSTALL_DIR}" ]];then
  echo "Creating install dir at ${INSTALL_DIR}"
  mkdir -p "${INSTALL_DIR}"
fi

echo "Checking if reviewdog is installed"
if [[ ! -f "${REVIEWDOG_PATH}" ]];then
  echo "Downloading reviewdog to ${REVIEWDOG_PATH}"
  wget -q -O - https://raw.githubusercontent.com/reviewdog/reviewdog/master/install.sh | sh -s -- -b "${INSTALL_DIR}" ${REVIEWDOG_VERSION}
fi

echo "Checking if checkstyle is installed"
if [[ ! -f "${CHECKSTYLE_PATH}" ]];then
  echo "Downloading checkstyle to ${CHECKSTYLE_PATH}"
  wget -q -O "${CHECKSTYLE_PATH}" https://github.com/checkstyle/checkstyle/releases/download/checkstyle-8.34/checkstyle-8.34-all.jar
fi

echo "All set up, launching reviewdog now."

export REVIEWDOG_GITHUB_API_TOKEN="${GITHUB_TOKEN}"

# Enter debug mode
set -x
exec java -jar "${CHECKSTYLE_PATH}" "${CHECKSTYLE_WORKDIR}" -c "${CHECKSTYLE_CONFIG}" -f xml \
 | ${REVIEWDOG_PATH} -f=checkstyle \
      -name="${REVIEWDOG_TOOL_NAME:-reviewdog}" \
      -reporter="${REVIEWDOG_REPORTER:-github-pr-check}" \
      -filter-mode="${REVIEWDOG_FILTER_MODE:-added}" \
      -fail-on-error="${REVIEWDOG_FAIL_ON_ERROR:-false}" \
      -level="${REVIEWDOG_LOGLEVEL:-info}"
set +x
