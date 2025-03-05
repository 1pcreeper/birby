import MainProps from './props/MainProps';
function Main({ children }: MainProps) {
    return (
        <>
            <main>
                <div className="mt-18">
                    {children}
                </div>
            </main>
        </>
    )
}
export default Main;