import React from 'react';

const ErrorPage: React.FC = () => {
  const isUrlIncorrect = true; // Replace with your logic to check if the URL is incorrect

  if (isUrlIncorrect) {
    return (
      <div>
        <h1>404 Error</h1>
        <p>Oops! The page you're looking for doesn't exist.</p>
      </div>
    );
  }

  // Render the correct page here

  return null; // Replace with the correct page component
};

export default ErrorPage;